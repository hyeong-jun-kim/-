package SecondWeekApril;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 적록색약 {
    static boolean[][] visited;
    static char[][] real;
    static char[][] unreal;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        real = new char[N][N];
        unreal = new char[N][N];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                if(input.charAt(j)=='G') unreal[i][j] = 'R';
                else unreal[i][j] = input.charAt(j);
                real[i][j] = input.charAt(j);
            }
        }
        // real에 값 저장
        visited = new boolean[N][N];
        int visible = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    //System.out.println(i+", "+j+"에 있는 "+real[i][j]+"을 시작으로 탐색");
                    dfs1(i, j);
                    visible++;
                }
            }
        }

        visited = new boolean[N][N];
        int invisible = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    //System.out.println(i+", "+j+"에 있는 "+unreal[i][j]+"을 시작으로 탐색");
                    dfs2(i, j);
                    invisible++;
                }
            }
        }

        System.out.println(visible+" "+invisible);
    }
    public static void dfs1(int x, int y){
        visited[x][y] = true;
        char letter = real[x][y];
        //System.out.println("현재 방문 위치: "+x+", "+y);

        // 상 하 좌 우
        if(y+1<N && !visited[x][y+1] && real[x][y+1] == letter){ dfs1(x,y+1); }
        if(y-1>=0 && !visited[x][y-1] && real[x][y-1] == letter){ dfs1(x,y-1); }
        if(x-1>=0 && !visited[x-1][y] && real[x-1][y] == letter){ dfs1(x-1,y); }
        if(x+1<N && !visited[x+1][y] && real[x+1][y] == letter){ dfs1(x+1,y); }

    }
    public static void dfs2(int x, int y){
        visited[x][y] = true;
        char letter = unreal[x][y];
        //System.out.println("현재 방문 위치: "+x+", "+y);

        // 상 하 좌 우
        if(y+1<N && !visited[x][y+1] && unreal[x][y+1] == letter){ dfs2(x,y+1); }
        if(y-1>=0 && !visited[x][y-1] && unreal[x][y-1] == letter){ dfs2(x,y-1); }
        if(x-1>=0 && !visited[x-1][y] && unreal[x-1][y] == letter){ dfs2(x-1,y); }
        if(x+1<N && !visited[x+1][y] && unreal[x+1][y] == letter){ dfs2(x+1,y); }

    }
}
