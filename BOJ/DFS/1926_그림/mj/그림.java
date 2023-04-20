package SecondWeekApril;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 그림 {


    /*
* 4 5
1 1 1 0 1
0 1 0 0 0
1 0 1 0 1
0 0 0 1 1
5
4
*
*
*
* 1 1
0
0
0
* */

    static int max;
    static int[][] input;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        input = new int[n][m];
        for(int i=0; i<n; i++){
            String[] stream = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                input[i][j] = Integer.parseInt(stream[j]);
            }
        }

        int paints=0;
        max=0;
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int temp=0;
                if(!visited[i][j] && input[i][j]==1){
                    visited[i][j] = true;
                    dfs(i,j,++temp,n,m);
                    paints++;
                }
            }
        }
        sb.append(paints);
        sb.append("\n");
        sb.append(max);
        System.out.println(sb);

    }

    public static void dfs(int x, int y, int temp, int n, int m){
        visited[x][y] = true;

        if(y+1<m && !visited[x][y+1] && input[x][y+1] == 1){ dfs(x,y+1,++temp,n,m); }
        if(y-1>=0 && !visited[x][y-1] && input[x][y-1] == 1){ dfs(x,y-1,++temp,n,m); }
        if(x-1>=0 && !visited[x-1][y] && input[x-1][y] == 1){ dfs(x-1,y,++temp,n,m); }
        if(x+1<n && !visited[x+1][y] && input[x+1][y] == 1){ dfs(x+1,y,++temp,n,m); }

        if(max<temp) max=temp;
    }
}
