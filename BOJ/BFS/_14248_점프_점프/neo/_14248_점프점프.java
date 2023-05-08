package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14248_점프점프 {
    static boolean[] visited;
    static int[] arr;
    static int ans = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; st.hasMoreTokens(); i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());
        visited[s] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()){
            int a = q.poll();
            int jump = arr[a];
            ans++;

            if(a+jump <= n && !visited[a+jump]){
                visited[a+jump] = true;
                q.offer(a+jump);
            }
            if(a-jump >= 1 && !visited[a-jump]){
                visited[a-jump] = true;
                q.offer(a-jump);
            }
        }

        System.out.println(ans);
    }
}