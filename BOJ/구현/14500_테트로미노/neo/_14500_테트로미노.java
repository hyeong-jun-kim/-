package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14500_테트로미노 {
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;

    public static void main(String args[]) throws IOException{
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
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 0);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }
    public static void dfs(int x, int y, int sum, int cnt){
        if(cnt == 3){
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m) {
                if(!visited[a][b]){
                    // ㅓ ㅗ ㅏ ㅜ 를 만들기 위해 다시한번 탐색
                    if(cnt == 1){
                        visited[a][b] = true;
                        dfs(x, y, sum + arr[a][b], cnt+1);
                        visited[a][b] = false;
                    }

                    visited[a][b] = true;
                    dfs(a, b, sum + arr[a][b], cnt + 1);
                    visited[a][b] = false;
                }
            }
        }
    }
}