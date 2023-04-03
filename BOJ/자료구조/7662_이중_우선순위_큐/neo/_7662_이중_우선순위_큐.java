package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _7662_이중_우선순위_큐 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            // 최소, 최대 힙에서 중복되서 뽑는걸 방지하기 위해 삽입, 삭제할 때 마다 map으로 관리 함
            // 해당 map으로 관리하지 않으면 이미 뽑혔던 요소를 또 뽑을 수 있어서 틀릴 수도 있음 => I 1, I 2, I 3, D -1, D -1, I -10, I -11, D 1, D 1
            HashMap<Integer, Integer> deleteMap = new HashMap();

            int insertCnt = 0;
            int deleteCnt = 0;

            for (int j = 0; j < m; j++) {
                String[] input = br.readLine().split(" ");
                char c = input[0].charAt(0);
                int value = Integer.parseInt(input[1]);

                if (c == 'I') {
                    maxHeap.offer(value);
                    minHeap.offer(value);

                    deleteMap.put(value, deleteMap.getOrDefault(value, 0) + 1);
                    insertCnt++;
                } else {
                    if (insertCnt == deleteCnt)
                        continue;

                    int num;
                    while(true) {
                        if (value == -1) {
                            num = minHeap.poll();
                        } else {
                            num = maxHeap.poll();
                        }

                        if(deleteMap.containsKey(num))
                            break;
                    }

                    deleteMap.put(num, deleteMap.getOrDefault(num, 1) - 1);
                    if (deleteMap.get(num) == 0)
                        deleteMap.remove(num);

                    deleteCnt++;
                }
            }

            // 큐가 비었는지 확인
            if (insertCnt == deleteCnt) {
                sb.append("EMPTY \n");
            } else {
                int min;
                int max;
                while (true) {
                    min = minHeap.isEmpty() ? maxHeap.peek() : minHeap.peek();
                    if (!deleteMap.containsKey(min)) { // 최대 힙에서 제거된 요소는 안뽑히게 하기
                        minHeap.poll();
                        continue;
                    }

                    max = maxHeap.isEmpty() ? minHeap.peek() : maxHeap.peek();
                    if (!deleteMap.containsKey(max)) { // 최소 힙에서 제거된 요소는 안뽑히게 하기
                        maxHeap.poll();
                        continue;
                    }

                    break;
                }

                sb.append(max + " " + min + "\n");
            }
        }

        System.out.println(sb);
    }
}