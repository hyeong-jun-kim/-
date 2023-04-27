package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1926_그림 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int m;

    static int[][] arr;
    static boolean[][] visited;
    static int width = 0;
    static int count = 0;
    static int tmp = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    visited[i][j] = true;
                    tmp = 1;
                    count++;
                    dfs(i, j);
                    width = Math.max(width, tmp);
                }
            }
        }

        System.out.println(count);
        System.out.println(width);
    }

    public static void dfs(int x, int y){
        for(int i = 0; i < 4; i++){
            int a = x + dx[i];
            int b = y + dy[i];

            if(a >= 0 && a < n && b >= 0 && b < m){
                if(!visited[a][b] && arr[a][b] == 1){
                    tmp++;
                    visited[a][b] = true;
                    dfs(a, b);
                }
            }
        }
    }
}