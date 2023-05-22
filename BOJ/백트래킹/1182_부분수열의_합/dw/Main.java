import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    static int cnt = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            dfs(0, 0, i, 0);
        }
        System.out.println(cnt);
    }

    static void dfs(int idx, int curLen, int len, int sum) {
        if (curLen == len) {
            if (sum == S) {
                cnt++;
            }
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, curLen + 1, len, sum + arr[i]);
                visited[i] = false;
            }
        }
    }
}