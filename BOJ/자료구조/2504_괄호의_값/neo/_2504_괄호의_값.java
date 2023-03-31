package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _2504_괄호의_값 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 올바른 괄호인지 검사
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    System.out.println(0);
                    return;
                }

                if(c == ')' && stack.peek() == '(')
                    stack.pop();
                else if(c == ']' && stack.peek() == '[')
                    stack.pop();
                else{
                    System.out.println(0);
                    return;
                }
            }
        }

        if(!stack.isEmpty()){
            System.out.println(0);
            return;
        }

        stack.clear();

        int answer = 0;
        boolean check = false;
        for(char c : s.toCharArray()){
            if(c == '(' || c == '['){
                check = false;
                stack.push(c);
            }
            else{
                int tmp = 1;
                if(!check){
                    for(char ch : stack){
                        if(ch == '('){
                            tmp *= 2;
                        }else{
                            tmp *= 3;
                        }
                    }

                    answer += tmp;
                }
                check = true;
                stack.pop();
            }
        }

        System.out.println(answer);
    }
}