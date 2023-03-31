package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493_탑 {
    static int[] answer;
    static class Node{
        int idx;
        int height;
        public Node(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
        answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int height = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){
                stack.push(new Node(i, height));
                continue;
            }

            if(stack.peek().height < height){
                while(!stack.isEmpty() && stack.peek().height < height){ // 작은 탑들 제거
                    stack.pop();
                }
            }

            // 수신 전송 가능 여부 확인
            if(!stack.isEmpty() && stack.peek().height >= height){
                answer[i] = stack.peek().idx + 1; // 0부터 시작했기 때문에 +1 해주기

                while(stack.peek().height == height)
                    stack.pop();
            }

            stack.push(new Node(i, height));
        }

        for(int i = 0; i < n; i++){
            System.out.print(answer[i] + " ");
        }
    }
}