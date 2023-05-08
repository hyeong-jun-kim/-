package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1315_효율적인_해킹 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] ans;
    static int max = Integer.MIN_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n+1];
        ans = new int[n+1];

        for(int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            visited = new boolean[n+1];
            q.offer(i);
            visited[i] = true;

            while(!q.isEmpty()){
                int node = q.poll();
                for(int a : adj[node]){
                    if(!visited[a]){
                        visited[a] = true;
                        q.offer(a);
                        ans[i]++;
                    }
                }
            }

            max = Math.max(max, ans[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            if(ans[i] == max)
                sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}