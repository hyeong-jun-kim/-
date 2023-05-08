package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14502_연구소 {
    static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static int[] ddx = {-1, 1, 0, 0, -1, -1, 1, 1}; // 대각선 고려
    static int[] ddy = {0, 0, -1, 1, -1, 1, -1, 1};

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][] wallVisited;
    static boolean[][] visited;
    static int[][] status;
    static ArrayList<Node> wallList;
    static Node[] wall;
    static boolean[] wv;
    static int[][] arr;
    static int[][] tmpArr;

    static int n;
    static int m;

    static int ans = Integer.MIN_VALUE;

    static Queue<Node> q;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        wallList = new ArrayList<>();
        wall = new Node[3];
        q = new LinkedList<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        wallVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 벽이 될 수 있는 장소 추가
                if(arr[i][j] == 0)
                    wallList.add(new Node(i, j));
            }
        }

        wv = new boolean[wallList.size()];

        dfs(0, 0);

        System.out.println(ans);
    }

    // 백트래킹
    public static void dfs(int depth, int idx) {
        if (depth == 3) {
            status = new int[n][m];
            visited = new boolean[n][m];

            tmpArr = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    tmpArr[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < 3; i++) {
                Node node = wall[i];
                int a = node.a;
                int b = node.b;

                tmpArr[a][b] = 1;
            }

            int cnt = 0;

            // 바이러스 감염시키기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tmpArr[i][j] == 2 && !visited[i][j]) {
                        q.offer(new Node(i, j));
                        while (!q.isEmpty()) {
                            Node node = q.poll();
                            int a = node.a;
                            int b = node.b;

                            for (int k = 0; k < 4; k++) {
                                int x = a + dx[k];
                                int y = b + dy[k];

                                if (x >= 0 && x < n && y >= 0 && y < m) {
                                    if (tmpArr[x][y] != 1 && !visited[x][y]) {
                                        visited[x][y] = true;
                                        tmpArr[x][y] = 2;
                                        q.offer(new Node(x, y));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 정상 구역 카운트
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(tmpArr[i][j] == 0)
                        cnt++;
                }
            }

            ans = Math.max(ans, cnt);
            return;
        }

        for (int i = idx; i < wallList.size(); i++) {
            if (!wv[i]) {
                wv[i] = true;
                wall[depth] = wallList.get(i);
                dfs(depth + 1, i);
                wv[i] = false;
            }
        }
    }
}