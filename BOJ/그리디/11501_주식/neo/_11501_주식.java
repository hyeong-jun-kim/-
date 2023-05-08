package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11501_주식 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[] arrMax = new int[n]; // 구간의 최댓 값을 담음

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            for(int j = n - 1; j >= 0; j--){
                max = Math.max(max, arr[j]);
                arrMax[j] = max;
            }

            long answer = 0;

            int count = 0;
            long sum = 0;

            for(int j = 0; j < n; j++){
                if(arr[j] < arrMax[j]){
                    sum += arr[j];
                    count++;
                }else{
                    if(count != 0){
                        answer += arr[j] * count - sum;
                        count = 0;
                        sum = 0;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}