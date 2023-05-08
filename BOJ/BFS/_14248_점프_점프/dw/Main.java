import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = Integer.parseInt(bf.readLine());
        visited = new boolean[N + 1];
        System.out.println(bfs(start));
    }

    private static int bfs(int cur) {
        Queue<Integer> que = new LinkedList<>();
        int result = 1;
        visited[cur] = true;
        que.add(cur);
        while (!que.isEmpty()) {
            int idx = que.poll();
            visited[idx] = true;
            if (idx - arr[idx] >= 1 && !visited[idx - arr[idx]]) {
                visited[idx - arr[idx]] = true;
                result++;
                que.add(idx - arr[idx]);
            }
            if (idx + arr[idx] < N + 1 && !visited[idx + arr[idx]]) {
                visited[idx + arr[idx]] = true;
                result++;
                que.add(idx + arr[idx]);
            }
        }
        return result;
    }
}