import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[]visited;
    static int max = 0;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }
        result = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        for (int i = 1; i < N + 1; i++) {
            if (max == result[i]) {
                System.out.print(i + " ");
            }
        }
    }

    static void bfs(int idx) {
        Queue<Integer> que = new LinkedList<>();
        visited[idx] = true;
        que.add(idx);

        while (!que.isEmpty()) {
            int num = que.poll();
            for (int n : list.get(num)) {
                if (!visited[n]) {
                    visited[n] = true;
                    result[n] += 1;
                    max = Math.max(result[n], max);
                    que.add(n);
                }
            }
        }
    }
}