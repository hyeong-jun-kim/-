package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오르막수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][10];
        for(int i=0; i<10; i++) dp[1][i] = 1;
        for(int i=1; i<n+1; i++) dp[i][0] = 1;
        if(n>=2) {
            for(int i=2; i<n+1; i++){
                for(int j=1; j<10; j++){
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 10007;
                }
            }
        }

        int result = 0;
        for(int i=0; i<10; i++) result += dp[n][i];
        System.out.println(result%10007);
    }
}
