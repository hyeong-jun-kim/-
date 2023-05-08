package LastWeekApril;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class 점프점프 {

    public static void main(String[] args) throws Exception {
        //BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        //String input = br.readLine();

        int n = 100000;

        int[] stone = new int[n];
        // for(int i=0; i<n; i++) stone[i] = Integer.parseInt(input.split(" ")[i]);
        // int ai = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            stone[i] = random(n);
            System.out.println(stone[i]);
        }

        int ai = random(n);
        System.out.println(ai);
        System.out.println("--------------------------");


        bfs(stone, ai-1,n);
    }

    static public void bfs(int[] stone, int ai, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] d = {-1,1};
        q.add(ai);
        visited[ai] = true;
        int count = 1;

        while(!q.isEmpty()){
            int x = q.poll();
            //if(visited[x]) continue;
            for(int i=0; i<2; i++){
                int next = x + stone[x] * d[i];
                if(next<n && next>=0 && !visited[next]){
                    visited[next] = true;
                    count++;
                    q.add(next);
                }
            }
        }
        System.out.println(count);
    }

    static public int random(int n){
        Random random = new Random();
        return random.nextInt(n-1)+1;
    }
}
