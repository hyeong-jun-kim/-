package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6603_로또 {
    static int[] arr;
    static int[] numArr; // depthArr
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if(k == 0)
                break;

            arr = new int[k];
            numArr = new int[6];

            for(int i = 0; i < k; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            dfs(0, 0);
            System.out.println();
        }
    }

    public static void dfs(int idx, int depth){
        if(depth == 6){
            for(int i = 0; i < 6; i++)
                System.out.print(numArr[i] + " ");

            System.out.println();
            return;
        }

        for(int i = idx; i < arr.length; i++){
            numArr[depth] = arr[i];
            dfs(i+1, depth+1);
        }
    }
}