package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1446_지름길 {
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int distance;

        public Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.end - edge.end;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] dp = new int[d + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(start, end, distance));
        }

        for (int i = 1; i <= d; i++) {
            dp[i] = dp[i - 1] + 1;

            while (!pq.isEmpty() && pq.peek().end == i) {
                Edge edge = pq.poll();
                dp[i] = Math.min(dp[i], dp[edge.start] + edge.distance);
            }
        }

        System.out.println(dp[d]);
    }
}