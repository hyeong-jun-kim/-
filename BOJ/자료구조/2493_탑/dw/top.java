import java.io.*;
import java.util.*;

public class top {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> stack = new Stack<>();
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek()[0] > num) {
                    sb.append(stack.peek()[1] + " ");
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                sb.append(0+" ");
            }
            stack.add(new int[]{num, i + 1});
        }
        System.out.println(sb);
    }
}
