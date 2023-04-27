package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10026_적록색약 {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] arr1;
    static char[][] arr2;

    static boolean[][] visited;

    static int answer1 = 0; // 색맹 X
    static int answer2 = 0; // 색맹 O
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr1 = new char[n][n];
        arr2 = new char[n][n];

        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < n; j++){
                arr1[i][j] = input.charAt(j);
            }

            input = input.replaceAll("G", "R");
            for(int j = 0; j < n; j++){
                arr2[i][j] = input.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, arr1[i][j], false);
                    answer1++;
                }
            }
        }

        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, arr2[i][j], true);
                    answer2++;
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    // c -> 색깔, check -> true = 색맹, != 색맹아님
    public static void dfs(int x, int y, char c, boolean check){
        for(int i = 0; i < 4; i++){
            int a = x + dx[i];
            int b = y + dy[i];

            if(a >= 0 && a < n && b >= 0 && b < n){
                if(check){
                    if(!visited[a][b] && arr2[a][b] == c){
                        visited[a][b] = true;
                        dfs(a, b, c, check);
                    }
                }else{
                    if(!visited[a][b] && arr1[a][b] == c){
                        visited[a][b] = true;
                        dfs(a, b, c, check);
                    }
                }
            }
        }
    }
}