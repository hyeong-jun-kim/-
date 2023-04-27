import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] graph;
    static int count =0;
    static int area = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    area = 1;
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max );
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        max = Math.max(area, max);
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < M && newY >= 0 && newY < N ) {
                if (!visited[newY][newX]&& graph[newY][newX] == 1) {
                    area++;
                    dfs(newY, newX);
                }
            }
        }
    }
}