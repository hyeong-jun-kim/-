package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _14891_톱니바퀴 {
    static class Gear{
        LinkedList<Integer> linkedList;
        int touchGear;
        int deTouchGear;

        public Gear(String input){
            linkedList = new LinkedList<>();
            for(int i = 0; i < 8; i++){
                int a = input.charAt(i) - '0';
                linkedList.add(a);
            }

            touchGear = linkedList.get(2);
            deTouchGear = linkedList.get(6);
        }

        // 시계 방향 -> 마지막 요소 제거하고 제일 앞으로 추가
        public void rotate(){
            int lastElement = linkedList.removeLast();
            linkedList.addFirst(lastElement);
        }

        // 반시계 방향 -> 첫번째 요소 제거하고 제일 마지막으로 추가
        public void deRotate(){
            int firstElement = linkedList.removeFirst();
            linkedList.addLast(firstElement);
        }

        // 1 -> 시계 방향, -1 -> 반시계 방향
        public void rotateByNum(int num){
            if(num == 1){
                rotate();
            }else{
                deRotate();
            }
        }

        // 터치기어 최신화
        public void refreshTouchGear(){
            touchGear = linkedList.get(2);
            deTouchGear = linkedList.get(6);
        }
    }

    static Gear[] gearList;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gearList = new Gear[4];
        for(int i = 0; i < 4; i++){
            String input = br.readLine();
            gearList[i] = new Gear(input);
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int rotate = Integer.parseInt(st.nextToken());

            Gear gear = gearList[idx];
            gear.rotateByNum(rotate);
            dfs(idx, idx, rotate);

            Arrays.stream(gearList).forEach(Gear::refreshTouchGear);
        }

        // 결과 값 계산
        int sum = 0;
        for(int i = 0; i < 4; i++){
            Gear gear = gearList[i];
            int num = gear.linkedList.get(0);
            if(num == 1)
                sum += Math.pow(2, i);
        }

        System.out.println(sum);
    }

    public static void dfs(int beforeIdx, int idx, int rotate){
        if(idx < 0 || idx >= 4)
            return;

        if(beforeIdx == idx){
            dfs(idx, idx - 1, rotate);
            dfs(idx, idx + 1, rotate);
            return;
        }

        int gearRotate = (rotate == 1)? -1 : 1;

        if(idx < beforeIdx && gearList[beforeIdx].deTouchGear != gearList[idx].touchGear){
            gearList[idx].rotateByNum(gearRotate);
            dfs(idx, idx - 1, gearRotate);
        } else if (idx > beforeIdx && gearList[beforeIdx].touchGear != gearList[idx].deTouchGear) {
            gearList[idx].rotateByNum(gearRotate);
            dfs(idx, idx + 1, gearRotate);
        }
    }
}