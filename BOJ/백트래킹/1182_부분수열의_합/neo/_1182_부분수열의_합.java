package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1182_부분수열의_합 {
    static int[] arr;
    static int n;
    static int s;
    static int answer = 0;
    static int[] numArr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            numArr = new int[i];
            dfs(0, 0, i);
        }

        System.out.println(answer);
    }

    public static void dfs(int idx, int depth, int max) {
        if (depth == max) {
            int sum = 0;
            for (int i = 0; i < max; i++)
                sum += numArr[i];

            if (sum == s)
                answer++;
            return;
        }

        for (int i = idx; i < n; i++) {
            numArr[depth] = arr[i];
            dfs(i + 1, depth + 1, max);
        }
    }
}