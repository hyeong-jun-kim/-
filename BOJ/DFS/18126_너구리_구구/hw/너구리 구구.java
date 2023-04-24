import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int[] visited;
    static int n;
    static long dist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1][n+1];
        visited = new int[n+1];

        for(int i=1; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 방과 b번 방 양방향 연결시키고 거리 넣기
            // arr[a][b] 또는 arr[b][a]가 0이 아니라면 연결되어있는것임.
            arr[a][b] = c;
            arr[b][a] = c;
        }
        solution();
        System.out.println(dist);
    }

    private static void solution() {
        visited[1] = 1;
        dfs(1, 0);
    }

    private static void dfs(int vertex, long distance) {
        dist = Math.max(dist, distance);
        for(int i=1; i<=n; i++) {
            if(arr[vertex][i] != 0 && visited[i] == 0) { //현재 방과 i번 방이 연결되어있고, 아직 방문을 하지 않았다면
//                System.out.println(vertex+"에서 "+i+"번 방으로 이동. 거리 =" +arr[vertex][i]);
                visited[i] = 1; //방문처리
                dfs(i, distance+ arr[vertex][i]);
                visited[i] = 0; //방문처리 풀기
            }
        }
    }
}
