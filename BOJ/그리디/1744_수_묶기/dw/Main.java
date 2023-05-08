import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            que.add(Integer.parseInt(bf.readLine()));
        }
        int sum = 0;
        int tmp = 1;
        boolean check = false;
        while (!que.isEmpty()) {
            if (que.peek() < 0 || que.peek() == 0) {
                int n = que.poll();
                sum += n;
                if (que.isEmpty()) {
                    break;
                }
                if (que.peek() == 0) {
                    sum += Math.abs(n);
                } else if (que.peek() < 0 && n < 0) {
                    sum += Math.abs(n);
                    sum += Math.abs(n) * Math.abs(que.poll());
                }
            } else {
                if (!check) {
                    if (que.size() % 2 == 0) {
                        tmp *= que.poll();
                        check = true;
                    } else {
                        sum += que.poll();
                    }
                } else {
                    int n = que.poll();
                    if (tmp == 1) {
                        sum += n + 1;
                    } else {
                        tmp *= n;
                        sum += tmp;
                    }
                    tmp = 1;
                    check = false;
                }
            }
        }
        System.out.println(sum);
    }
}