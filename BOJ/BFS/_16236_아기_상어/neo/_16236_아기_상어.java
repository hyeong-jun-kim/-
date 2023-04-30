package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16236_아기_상어 {
    public static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static class Shark {
        int size;
        int a;
        int b;
        int xp; // 먹이를 먹은 갯수

        public Shark(int a, int b) {
            this.a = a;
            this.b = b;
            this.size = 2;
        }

        public void getXP() {
            xp++;

            if (xp == size) {
                xp = 0;
                size++;
            }
        }
    }

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int n;
    public static int[][] arr;
    public static int[][] distance;
    public static boolean[][] visited;
    public static int ans = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        Shark shark = null;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 9)
                    shark = new Shark(i, j);
            }
        }

        Queue<Node> fq = new LinkedList<>(); // 먹이의 위치
        Queue<Node> q = new LinkedList<>();

        fq.offer(new Node(shark.a, shark.b));

        while (!fq.isEmpty()) {
            Node feed = fq.poll();
            visited = new boolean[n][n];
            distance = new int[n][n];

            q.offer(new Node(feed.a, feed.b));
            visited[feed.a][feed.b] = true;
            arr[feed.a][feed.b] = 0;

            Node fish = null;
            int minDistance = Integer.MAX_VALUE;

            // distance 배열 갱신
            while (!q.isEmpty()) {
                Node node = q.poll();
                int a = node.a;
                int b = node.b;

                for (int i = 0; i < 4; i++) {
                    int x = a + dx[i];
                    int y = b + dy[i];

                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        if (!visited[x][y] && arr[x][y] <= shark.size) {
                            distance[x][y] = distance[a][b] + 1;
                            visited[x][y] = true;
                            q.offer(new Node(x, y));

                            if (arr[x][y] != 0 && arr[x][y] < shark.size && distance[x][y] <= minDistance) {
                                if (distance[x][y] == minDistance) {
                                    // y축 같으면 왼쪽, y축 다르면 위쪽
                                    if ((x == fish.a && y < fish.b) || (x < fish.a))
                                        fish = new Node(x, y);
                                } else {
                                    fish = new Node(x, y);
                                    minDistance = distance[x][y];
                                }
                            }
                        }
                    }
                }
            }

            if (fish == null) // 먹이를 안먹었을 때
                break;

            ans += minDistance;
            shark.getXP();

            fq.offer(new Node(fish.a, fish.b));
        }

        System.out.println(ans);
    }
}