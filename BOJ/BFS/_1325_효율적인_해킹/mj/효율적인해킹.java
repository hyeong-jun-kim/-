package LastWeekApril;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 효율적인해킹 {

    static ArrayList<ArrayList<Integer>> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n =Integer.parseInt(input[0]);
        int m =Integer.parseInt(input[1]);

        map = new ArrayList<>();

        // ArrayList 생성
        for(int i=0; i<n; i++) {
            map.add(new ArrayList<>());
        }

        // 신뢰하는 컴퓨터 저장하기
        for(int i=0; i<m; i++){
            input = br.readLine().split(" ");
            map.get(Integer.parseInt(input[1])-1)
                    .add(Integer.parseInt(input[0])-1);
        }

        // 각 컴퓨터를 해킹했을 때 같이 해킹할 수 있는 컴퓨터 수 구하기
        int[] count = new int[n]; // bfs 결과, 컴퓨터 개수
        int max = 0;
        for(int i=0; i<n; i++){
            if(map.get(i).size()==0) continue;
            count[i] = bfs(i, n);
            max = Math.max(max, count[i]);
        }

        // 최대값 찾기
        for(int i=0; i<n; i++){
            if(count[i]==max) System.out.print((i+1)+" ");
        }
    }

    private static int bfs(int i, int n) {  // i는 0부터 n-1까지
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        q.add(i);
        visited[i] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int j=0; j<map.get(now).size(); j++){
                int index = map.get(now).get(j);
                if(!visited[index]){
                    q.add(index);
                    visited[index] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
