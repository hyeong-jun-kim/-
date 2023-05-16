package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class _11057_오르막_수 {
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[n+1][10];

            for(int i = 0; i <= 9; i++){
                dp[1][i] = 1;
            }

            for(int i = 2; i <= n; i++){
                int sum = 0;
                for(int j = 0; j <= 9; j++){
                    sum += dp[i-1][j] % 10007;
                }

                dp[i][0] = sum;

                int tmp = 0;
                for(int j = 1; j <= 9; j++){
                    tmp += dp[i-1][j-1] % 10007;
                    dp[i][j] = sum - tmp;
                }
            }

            int answer = 0;

            for(int i = 0; i <= 9; i++){
                answer += dp[n][i] % 10007;
            }

            System.out.println(answer % 10007);
        }
    }