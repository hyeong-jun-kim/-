package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18126_너구리_구구 {
    static int[][] graph;
    static boolean[] visited;
    static long answer = Long.MIN_VALUE;
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
            graph[b][a] = c;
        }

        visited[1] = true;
        dfs(1, 0);
        System.out.println(answer);
    }

    public static void dfs(int start, long distance){
        answer = Math.max(answer, distance);

        for(int i = 1; i <= n; i++){
            if(graph[start][i] != 0 && !visited[i]){
                visited[i] = true;
                dfs(i, distance + graph[start][i]);
                visited[i] = false;
            }
        }
    }
}