import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] visited;
    static int[] arr;
    static int n;
    static int answer;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //접근 : 각 학생들을 노드로 생각하고 연결관계 입력받기
        int t = Integer.parseInt(br.readLine()); //테이스케이스 개수

        while(t > 0) { //test 케이스 만큼 반복
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            visited = new int[n+1];
            arr = new int[n+1];
            for(int i=1; i<=n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(solution() + "\n");
            t--;
        }
        System.out.println(sb);
    }

    private static int solution() {
        answer = n;
        for(int i=1; i<=n; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                dfs(i, i, 1);
                if(!flag) {
                    visited[i] = 0; //팀이 되지 않았다면 방문처리 풀기
                }
                flag = false;
            }
        }
        return answer;
    }

    private static void dfs(int vertex, int startVex, int count) {
        int next = arr[vertex]; //다음 노드 번호
        if (next == startVex) {
            flag = true;
            answer -= count;
        } else if (visited[next] == 0) {
            visited[next] = 1;
            dfs(next, startVex, count+1);
            if(!flag) visited[next] = 0; //팀이 되지 않았다면 방문처리 풀기
        }
    }
}
