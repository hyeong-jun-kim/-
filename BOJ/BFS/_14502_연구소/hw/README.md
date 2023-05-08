## Info
<a href="https://www.acmicpc.net/problem/14502" rel="nofollow">14502_연구소</a>

## ❗ 풀이 방법
1. main함수에서 n, m, graph 입력받기
2. graph에서 0인 곳 기록 -> zeroIndexList에 기록한다.
3. graph에서 2인 곳 기록 ->virusIndex에 기록한다.
4. zeroIndexList에서, 3중 for문으로 3개의 원소를 뽑는다.
5. 뽑은 3곳의 위치에 벽을 세워보고 bfs를 돌려서 바이러스를 퍼트려본 다음, 안전영역의 갯수를 세보고 max값을 갱신한다.
6. 임시로 벽을 세워본 곳을 다시 빈공간으로 바꿔놓는다.
7. 4~6 과정을 반복한다.

## 🙂 새로 알게된 점
처음엔 조합수를 구하는 것이 아닌 0을 만나면 벽으로 바꿔주고, 벽으로 바꿔준 횟수가 3이되면 bfs를 돌리는 식으로 풀었다.<br>
### 처음 풀이 코드
```java
import java.util.*;
public class Main {
    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static Queue<Position> tmp = new LinkedList<>();
    static Queue<Position> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //세로
        m = sc.nextInt();   //가로
        int[][] graph = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                graph[i][j] = sc.nextInt();
                if(graph[i][j] == 2) {  //바이러스 위치 기록
                    queue.offer(new Position(i, j));
                }
            }
        }
        System.out.println(solution(graph));
    }
    private static int solution(int[][] graph) {
        // 접근 -> 벽을 세개 세워보는 조합 수 구하기?
        // 근거 -> n과 m의 범위가 엄청 작기 때문에 가능할 것 같다.

        int answer = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(graph[i][j] == 0) {  //0을 만난다면 벽을 세워보기
                    graph[i][j] = 1;    //벽 세우기
                    tmp.offer(new Position(i, j));  //임시 벽 좌표 기록

                    if(tmp.size() == 3) {   //임시 벽을 세개 세웠다면 bfs 돌려보기
                        //벽 세워놓은 것 복사
                        int[][] arr = new int[n][m];
                        for(int k=0; k<n; k++) {
                            for (int l=0; l<m; l++) {
                                arr[k][l] = graph[k][l];
                            }
                        }
                        int count = bfs(arr);
                        answer = Math.max(answer, count);

                        Position pos = tmp.poll();
                        graph[pos.x][pos.y] = 0;    //원상복구
                    }
                }
            }
        }
        return answer;
    }

    private static int bfs(int[][] arr) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Position> queue2 = new LinkedList<>();
        for(Position p : queue) {
            queue2.offer(p);
        }

        while(!queue2.isEmpty()) {
            Position pos = queue2.poll();
            for(int i=0; i<4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny< m && arr[nx][ny] == 0) {
                    queue2.offer(new Position(nx, ny));
                    arr[nx][ny] = 2;
                }
            }
        }

        // bfs로 바이러스 퍼트려본 다음 안전영역 갯수 세기
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) count ++;
            }
        }
        return count;
    }
}

```

이렇게 하면 모든 조합수를 구하는 것이 아니라, 연속된 빈공간에 대해서만 따지는 것이기 때문에 모든 경우의 수를 따질 수 없다.<br>

그래서 벽을 세워볼 수 있는 모든 경우의 수에 대하여 bfs를 돌려야 한다는 것을 깨닫고 코드를 다시 작성하였다. "연속된"과 "모든 경우의 수" 에 대하여 다시 한번 더 생각해보는 계기가 되었다.


