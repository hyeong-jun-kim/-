package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;

public class 위장 {
    static boolean[] visited;
    static ArrayList<Integer> list;
    static int answer = 0;

    public static void main(String args[]){
        int answer = solution(new String[][]{{"a", "A"}, {"b", "A"}, {"c", "B"}, {"d", "B"}, {"e", "C"}, {"f", "C"}});
        System.out.println(answer);
    }
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String key = clothes[i][1];

            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }

        list = new ArrayList<>();
        for(String key : hashMap.keySet()){
            list.add(hashMap.get(key));
        }

        // process
        for(int i = 1; i <= list.size(); i++){
            visited = new boolean[hashMap.size()];
            dfs(0, 0, i);
        }

        return answer;
    }

    public static void dfs(int depth, int idx, int max){
        if(depth == max){
            int tmp = 1;
            for(int i = 0; i < visited.length; i++){
                if(visited[i]){
                    tmp *= list.get(i);
                }
            }
            answer += tmp;
            return;
        }

        for(int i = idx; i < list.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, i, max);
                visited[i] = false;
            }
        }
    }
}