package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class _9466_텀_프로젝트 {
    static int m;
    static LinkedHashSet<Integer> hashSet; // 사이클 탐지용 해시 셋
    static int[] arr;
    static int[] status; // 프로젝트에 속한 학생을 나타냄 0 -> 프로젝트 팀에 속하지 않음, 1 -> 프로젝트 팀에 속함

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hashSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[m + 1];
            status = new int[m + 1];
            for (int j = 1; st.hasMoreTokens(); j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= m; j++) {
                hashSet.clear();

                if (status[j] != 0)
                    continue;

                dfs(j);
            }

            int answer = 0;

            // 어느 프로젝트에도 속하지 않는 학생 수 구하기
            for (int j = 1; j <= m; j++) {
                if (status[j] == -1)
                    answer++;
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int node) {
        // 사이클 발생 시, 사이클 발생한 노드 이후로 모든 status 1
        if (hashSet.contains(node)) {
            boolean check = false;
            for (int n : hashSet) {
                if (n == node)
                    check = true;

                if (check)
                    status[n] = 1;
            }

            return;
        }

        if (status[node] != 0) // 프로젝트 팀이 결정된 노드에 방문했을 경우 가지치기
            return;

        if (arr[node] == node) { // 팀 인원이 혼자인 경우, 해당 노드를 거치면 무조건 팀이 결성될 수 없음
            status[node] = 1;
            return;
        }

        status[node] = -1;
        hashSet.add(node);

        dfs(arr[node]);
    }
}