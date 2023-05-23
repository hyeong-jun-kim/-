package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9742_순열 {
    static char[] chArray;
    static char[] depthArray;
    static boolean[] visited;
    static int cnt = 0;
    static boolean check = false;
    static String answer = "No permutation";

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null){
            String[] inputs = input.split(" ");
            String ch = inputs[0];
            int k = Integer.parseInt(inputs[1]);
            cnt = 0;

            depthArray = new char[ch.length()];
            visited = new boolean[ch.length()];
            check = false;

            answer = "No permutation";

            chArray = ch.toCharArray();

            dfs(0, k);

            if(!check) {
                StringBuilder sb = new StringBuilder();

                sb.append(new String(chArray)).append(" ").append(k)
                        .append(" ").append("=").append(" ").append(answer);

                System.out.println(sb);
            }
        }
    }

    public static void dfs(int depth, int k){
        if(cnt > k)
            return;

        if(depth == chArray.length) {
            cnt++;
            if(cnt == k){
                StringBuilder sb = new StringBuilder();

                sb.append(new String(chArray)).append(" ").append(k)
                        .append(" ").append("=").append(" ");

                for (char c : depthArray) {
                    sb.append(c);
                }

                check = true;
                System.out.println(sb);
            }
            return;
        }

        for(int i = 0; i < chArray.length; i++){
            if(!visited[i]){
                visited[i] = true;
                depthArray[depth] = chArray[i];
                dfs(depth+1, k);
                visited[i] = false;
            }
        }
    }
}