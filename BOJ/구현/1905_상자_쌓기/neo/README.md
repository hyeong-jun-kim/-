## Info
<a href="https://www.acmicpc.net/problem/1905" rel="nofollow">1905 상자 쌓기</a>

### 전에 시도했던 방법 들

### 1. 세그먼트 트리

* 세그먼트 트리는 구간의 최대합을 O(n)이 아닌, O(log n)으로 구할 수 있는 알고리즘이다.
* 해당 문제는 범위 (x, y) 구간의 최대 값 (상자의 높이)를 구하면 되는데, 최대 값을 빠르게 구하면 답이 나올 것 같아 세그먼트 트리에 대해서도 공부를 했었다.
* 1차원 세그먼트 트리는 도전해 볼 수 있을 것 같다는 생각이 들었으나 2차원 세그먼트 트리는 아직 이해하기 어려운 것 같아 세그먼트 트리가 아닌 다른 알고리즘으로 도전해봐야겠다는 생각을 했다.

### 2. BFS로 최대 합 구하기

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] heightArr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] answer;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        answer = new int[x + 1][y + 1];
        heightArr = new int[x + 1][y + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int lz = Integer.parseInt(st.nextToken());
            int px = Integer.parseInt(st.nextToken());
            int py = Integer.parseInt(st.nextToken());
            visited = new boolean[x + 1][y + 1];

            // bfs
            Queue<Node> q = new LinkedList<Node>();
            q.offer(new Node(lx, ly));
            while (!q.isEmpty()) {
                Node node = q.poll();
                int x1 = node.x;
                int y1 = node.y;
                int height = heightArr[lx][ly];
                for (int j = 0; j < 4; j++) {
                    int a = x1 + dx[j];
                    int b = y1 + dy[j];

                    if (a >= lx && a <= lx + px && b >= ly && b <= ly + py) {
                        if (!visited[a][b]) {
                            height = Math.max(height, heightArr[a][b]); // a, b에 height보다 더 큰 값이 있을 수 있기 떄문에 비교해준다.
                            heightArr[a][b] = height + lz;
                            visited[a][b] = true;
                            q.offer(new Node(a, b));
                        }
                    }
                }
            }

        }
        // 최대 값 찾기
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= x; i++){
            for(int j = 1; j <= y; j++){
                answer = Math.max(answer, heightArr[i][j]);
            }
        }

        System.out.println(answer);
    }
}
```

* bfs를 통해 heightArr 배열을 갱신시켜주고, 마지막에 해당 배열에서 최대 값을 찾아서 리턴해주면 답이 나올 것이라고 생각했다.
* 테스트케이스는 맞췄으나, 코드를 제출했을 때 메모리 초과라고 떠서 실패했었다. bfs를 할때는 메모리를 고려해서 하는게 중요하다고 생각했다.
    * 대략적으로 계산해보면 int는 4 바이트, boolean은 1바이트이다. 따라서 입력값이 최대 1000이 들어왔다고 하면, 4 * 1000 * 1000 = 4MB이고 boolean은 1 * 1000 * 1000 = 1MB이다.
    * 여기서, n이 2만이니까 메모리 초기화가 안되면 1MB * 20000이 될 수 있어서 메모리 초과가 발생하는 것 같다고 생각했었다.

### 3. 우선순위 큐로 최대 높이 구하기

```java
import java.util.*;
import java.io.*;

public class Main {
    static class Box implements Comparable<Box> {
        int x1;
        int x2;
        int y1;
        int y2;
        long height;

        public Box(int x1, int lx, int y1, int ly) {
            this.x1 = x1;
            this.x2 = x1 + lx;
            this.y1 = y1;
            this.y2 = y1 + ly;
        }

        public Box(int x1, int lx, int y1, int ly, long height) {
            this.x1 = x1;
            this.x2 = x1 + lx;
            this.y1 = y1;
            this.y2 = y1 + ly;
            this.height = height;
        }

//         겹치는 영역이 있는지 확인하는 메서드
        public long getOverlapArea(Box b) {
            int xOverlap = Math.max(0, Math.min(this.x2, b.x2) - Math.max(this.x1, b.x1));
            int yOverlap = Math.max(0, Math.min(this.y2, b.y2) - Math.max(this.y1, b.y1));
            return (long) xOverlap * yOverlap;
        }

        public boolean isDuplicatedArea(Box b) {
            long overlap = getOverlapArea(b);
            return overlap > 0;
        }

        public void setHeight(long height) {
            this.height = height;
        }

        @Override
        public int compareTo(Box box) {
            return box.height > this.height? 1 : -1;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Box> tmpList = new ArrayList<>();

        PriorityQueue<Box> pq = new PriorityQueue<Box>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int lz = Integer.parseInt(st.nextToken());
            int px = Integer.parseInt(st.nextToken());
            int py = Integer.parseInt(st.nextToken());

            boolean check = false;
            Box defaultBox = new Box(px, lx, py, ly);

            Iterator<Box> iter = pq.iterator();
            while (iter.hasNext()) {
                Box b = iter.next();
                // 사각형의 꼭짓점 4개 구하기
                if (defaultBox.isDuplicatedArea(b)) {
                    defaultBox.setHeight(b.height + lz);
                    pq.offer(defaultBox);
                    check = true;
                    break;
                }
            }

            if (!check)
                pq.offer(new Box(px, lx, py, ly, lz));
        }

        System.out.println(pq.peek().height);
    }
}
```

* 테스트 케이스는 통과 됐었으나, 해당 풀이과정에서 **한가지 치명적인 문제**가 존재했다.
* 우선순위 큐에서 순회를 할 때, `forEach`나 `Iterator`를 통해서 순회를 하면 인덱스별로 탐색을 하기 때문에, 우선순위가 보장이 안된다.
    * 따라서, 우선순위 큐로 최대 값을 갱신시켜주는 것이 아닌 리스트에서 하나씩 탐색을 하면서 최댓 값을 갱신시켜주는 방식으로 풀었다.

### 풀이 과정
1. Box 객체를 만든다.
    1. Box 객체에는 다음과 같은 변수가 들어있다. x1, x2, y1, y2, height
    2. Box 객체는 다음과 같은 메서드가 있다. 1) 다른 Box 객체랑 겹치는 영역이 존재하는지 확인하는 메서드 2) 높이를 설정하는 메서드
        1. 겹치는 영역이 존재하는지 확인하는 메서드는 x2, b.x2의 최솟값과 x1, b.x1의 최댓값을 뺀 값과 y2, b.y2의 최솟값과 y1, b.y1의 최솟값을 뺀 값을 곱했을 때 0이면 안겹치고, 초과일 때는 겹친다고 판별한다.
2. 리스트를 탐색하면서 만약 리스트의 요소가 쌓을려는 박스랑 겹치면 지금까지 나온 임시 최댓값보다 큰지 비교하고, 리스트의 요소의 높이 + lz랑 전체 높이보다 큰지 다시한번 비교한다.
3. 만약에, 쌓을려는 박스가 다른 박스랑 하나도 겹치지 않는다면 check가 false가 된다. 이러면 lz의 높이로 리스트에 박스를 넣어주면 되는데 ,주의할 점으로는 해당 lz의 높이만으로도 다른 박스들보다 클 수 있기 때문에 lz랑 maxHeight 비교를 해야한다.   

### 새로 알게된 사실
* 세그먼트 트리에 대한 개념을 숙지하게 되었다.
* 우선순위 큐에서 forEach와 Iterator로 순회를 진행할 때, 우선순위가 보장되지는 않는다는 사실을 알았다.
* bfs는 생각보다 많은 메모리를 잡아먹는다는 것을 알게되었다. 입력 값을 보고 메모리 초과가 뜰지 안뜰지 생각하는 습관을 가져야겠다.