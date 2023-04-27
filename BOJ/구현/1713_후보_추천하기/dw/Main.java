import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        PriorityQueue<Student> pq = new PriorityQueue<>((o1, o2) -> o1.up == o2.up ? o1.idx - o2.idx : o1.up - o2.up);
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Loop1: for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            for (Student s : pq) {
                if (s.num == tmp) {
                    pq.remove(s);
                    pq.add(new Student(s.num, s.up + 1, s.idx));
                    continue Loop1;
                }
            }
            if (pq.size() >= N) {
                pq.poll();
            }
            pq.add(new Student(tmp, 1, i));
        }
        Student[] arr = new Student[pq.size()];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = pq.poll();
        }
        Arrays.sort(arr, (o1, o2) -> o1.num - o2.num);
        for (Student s : arr) {
            System.out.print(s.num + " ");
        }
    }

    static class Student {
        private int num;
        private int up;
        private int idx;

        public Student(int num, int up, int idx) {
            this.num = num;
            this.up = up;
            this.idx = idx;
        }
    }
}