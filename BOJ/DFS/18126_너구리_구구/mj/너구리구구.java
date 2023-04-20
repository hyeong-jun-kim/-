package SecondWeekApril;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
*
*
*
* 7
1 2 3
1 3 3
1 5 3
1 6 3
1 4 3
4 5 3
*
* 4
1 2 3
2 3 2
2 4 4
*
*
* 10
1 2 1
1 5 6
2 3 2
2 4 5
3 6 8
4 5 3
4 6 2
5 8 10
6 9 9
*
*
* 5
1 4 6
1 2 2
1 3 4
2 3 1
*
*
* 8
1 2 3
1 4 10
3 5 5
3 8 4
4 7 5
2 3 1
2 4 3
* */



public class 너구리구구 {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(0);
            System.exit(0);
        }
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int i=1; i<n; i++){
            String input = br.readLine();
            if(input==null) break;
            if(map.containsKey(Integer.parseInt(input.split(" ")[0]))){
                map.get(Integer.parseInt(input.split(" ")[0])).add(
                        new int[]{Integer.parseInt(input.split(" ")[1]),
                                Integer.parseInt(input.split(" ")[2])});
            }
            else{
                // 해당 key에 몇 번 방문했는지로 index 정하려고
                map.put(Integer.parseInt(input.split(" ")[0]),
                        new ArrayList<>(Collections.singleton(new int[]{1})));
                map.get(Integer.parseInt(input.split(" ")[0])).add(
                        new int[]{Integer.parseInt(input.split(" ")[1]),
                                Integer.parseInt(input.split(" ")[2])});
            }
        }

        // 입력값 모두 저장됨, 탐색 시작
        //  value(ArrayList)/int[]/int
        Stack<Integer> visited = new Stack<>();
        Stack<Integer> distance = new Stack<>();
        long max = 0;
        long temp = 0;

        int valueIndex = map.get(1).get(0)[0];
        visited.add(1);

        while(map.get(1).get(0)[0]<map.get(1).size()) {

            int dirSize = map.get(visited.get(visited.size()-1)).get(valueIndex)[1]; // 거리
            int direction = map.get(visited.get(visited.size()-1)).get(valueIndex)[0]; // 방 번호
            temp += dirSize;
            distance.push(dirSize);
            visited.push(direction);

            if (!map.containsKey(visited.lastElement())) {
                // direction이 목적지 노드가 될 때
                max = Math.max(temp, max);
                visited.pop();
                map.get(visited.lastElement()).get(0)[0]++; // index로 쓰는 배열 값 증가
                temp-= distance.pop();

                while(visited.size()>0 && map.get(visited.lastElement()).get(0)[0]==map.get(visited.lastElement()).size()){
                    map.get(visited.lastElement()).get(0)[0]=1;
                    visited.pop();
                    if(visited.size()>0 && map.containsKey(visited.lastElement())) {
                        map.get(visited.lastElement()).get(0)[0]++;
                        temp-=distance.pop();
                    }

                    if(visited.size()==0 || map.get(1).get(0)[0]==map.get(1).size()) {
                        System.out.println(max);
                        System.exit(0);
                    }
                }
            }
            valueIndex = map.get(visited.lastElement()).get(0)[0];
        }
        System.out.println(max);
    }
}
