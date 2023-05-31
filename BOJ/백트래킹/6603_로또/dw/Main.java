import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            arr = new int[N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0,"");
            System.out.println();
        }
    }

    private static void dfs(int idx, int depth,String str) {
        if (depth == 6) {
            System.out.println(str);
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1, str + arr[i] + " ");
                visited[i] = false;
            }
        }
    }
}