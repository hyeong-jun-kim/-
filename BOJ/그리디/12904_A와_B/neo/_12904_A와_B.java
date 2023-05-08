package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12904_A와_B {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String t = br.readLine();
        StringBuilder sb = new StringBuilder(t);

        int answer = 0;

        while(sb.length() >= s.length()){
            if(sb.toString().equals(s)) {
                answer = 1;
                break;
            }

            int c = sb.charAt(sb.length() - 1);

            if(c == 'A'){
                // 문자열 뒤에 A를 제거
                sb.deleteCharAt(sb.length() - 1);
            }else{
                // B를 제거하고 문자열을 뒤집는다
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }

        System.out.println(answer);
    }
}