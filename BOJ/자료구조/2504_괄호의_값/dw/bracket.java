import java.io.*;
import java.util.*;
//괄호의 값
public class bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split("");
        if (arr[0].equals(")") || arr[0].equals("]")) {
            System.out.println(0);
            return;
        }
        Stack<String> stack = new Stack<>();
        for (String str : arr) {
            if (str.equals("(") || str.equals("[")) {
                stack.push(str);
            } else if (str.equals(")")) {
                int tmp = 0;
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    if (stack.peek().equals("[")) {
                        System.out.println(0);
                        System.exit(0);
                    }
                    tmp += Integer.parseInt(stack.pop());
                }
                if (stack.isEmpty()) {
                    break;
                }
                stack.pop();
                if (tmp == 0) {
                    tmp = 1;
                }
                stack.push(String.valueOf(2 * tmp));
            } else {
                int tmp = 0;
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    if (stack.peek().equals("(")) {
                        System.out.println(0);
                        System.exit(0);
                    }
                    tmp += Integer.parseInt(stack.pop());
                }
                if (stack.isEmpty()) {
                    break;
                }
                stack.pop();
                if (tmp == 0) {
                    tmp = 1;
                }
                stack.push(String.valueOf(3 * tmp));
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            if (stack.contains("(") || stack.contains("[")) {
                System.out.println(0);
                return;
            } else {
                result += Integer.parseInt(stack.pop());
            }
        }
        System.out.println(result);

    }
}
