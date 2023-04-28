import java.io.*;

public class Main {
    static int N ;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static boolean[][] abnormalVisited;
    static String[][] normalGraph;
    static String[][] abnormalGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        normalGraph = new String[N][N];
        abnormalGraph = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] tmp = bf.readLine().split("");
            for (int j = 0; j < N; j++) {
                normalGraph[i][j] = tmp[j];
                if (tmp[j].equals("G")) {
                    abnormalGraph[i][j] = "R";
                } else {
                    abnormalGraph[i][j] = tmp[j];
                }
            }
        }
        visited = new boolean[N][N];
        abnormalVisited = new boolean[N][N];
        int normalCnt = 0, abnormalCnt =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, normalGraph[i][j]);
                    normalCnt+=1;
                }
                if (!abnormalVisited[i][j]) {
                    abnormalDfs(i, j, abnormalGraph[i][j]);
                    abnormalCnt+=1;
                }
            }
        }
        System.out.println(normalCnt + " " + abnormalCnt);
    }

    static void dfs(int y, int x, String color) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[ny][nx] && normalGraph[ny][nx].equals(color)) {
                    dfs(ny, nx, color);
                }
            }
        }
    }

    static void abnormalDfs(int y, int x, String color) {
        abnormalVisited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!abnormalVisited[ny][nx] && abnormalGraph[ny][nx].equals(color)) {
                    abnormalDfs(ny, nx, color);
                }
            }
        }
    }
}