package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663_N_Queen {
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, -1, 1};
    static int answer = 0;
    static int[][] board; // 초기 상태는 0이며, 1이면 퀸이 존재
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int depth){
        if(depth == n){
            answer++;
            return;
        }

        for(int i = 0; i < n; i++){
            if(isPromising(depth, i)){
                board[depth][i] = 1;
                dfs(depth+1);
                board[depth][i] = 0;
            }
        }
    }

    public static boolean isPromising(int a, int b){
        // 상, 하
        for(int i = 0; i < a; i++){
            if(board[i][b] == 1)
                return false;
        }

        // 대각선
        for(int i = 0; i < 4; i++){
            int x = a;
            int y = b;

            while(true){
                x += dx[i];
                y += dy[i];

                if(!(x >= 0 && x < n && y >= 0 && y < n))
                    break;

                if(board[x][y] == 1)
                    return false;
            }
        }

        return true;
    }
}