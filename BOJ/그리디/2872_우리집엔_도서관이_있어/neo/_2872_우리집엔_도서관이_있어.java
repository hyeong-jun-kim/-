package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2872_우리집엔_도서관이_있어 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int idx = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] == n)
                idx = i;
        }

        int cnt = 1;

        int value = arr[idx];
        for(int i = idx - 1; i >= 0; i--){
            if(value - arr[i] == 1) {
                value = arr[i];
                cnt++;
            }
        }

        System.out.println(n - cnt);
    }
}