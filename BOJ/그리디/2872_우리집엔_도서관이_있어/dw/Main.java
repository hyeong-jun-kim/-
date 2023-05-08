import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int maxIdx =0;
        int max = N;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            if (arr[i] == N) {
                maxIdx = i;
            }
        }
        for (int i = maxIdx; i >= 0; i--) {
            if (arr[i] == max - 1) {
                max --;
                cnt ++;
            }
        }
        System.out.println(N - cnt);
    }
}