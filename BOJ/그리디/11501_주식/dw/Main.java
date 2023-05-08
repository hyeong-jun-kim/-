import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            long[] arr = new long[N];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long max = arr[N - 1];
            long result = 0;
            for (int j = N - 2; j >= 0; j--) {
                if (arr[j] < max) {
                    result += max - arr[j];
                }
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            System.out.println(result);
        }
    }
}