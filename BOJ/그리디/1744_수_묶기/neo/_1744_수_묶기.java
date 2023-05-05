package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _1744_수_묶기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0){
                maxHeap.offer(num);
            }else{
                minHeap.offer(num);
            }
        }

        long sum = 0;

        while(maxHeap.size() >= 2){
            int a = maxHeap.poll();
            int b = maxHeap.poll();

            if(b == 1)
                sum += a + b;
            else
                sum += a * b;
        }

        while(minHeap.size() >= 2){
            int a = minHeap.poll();
            int b = minHeap.poll();

            sum += a * b;
        }

        // 남아있는 요소 더하기
        if(!maxHeap.isEmpty()){
            sum += maxHeap.poll();
        }

        if(!minHeap.isEmpty()){
            sum += minHeap.poll();
        }

        System.out.println(sum);
    }
}