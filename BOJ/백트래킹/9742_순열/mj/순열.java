package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 순열 {
    static ArrayList<String> result;
    static boolean[] used;
    static int count;
    static String input1;
    static int input2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input="";
        while((input = br.readLine()) != null){
            String[] ip = input.split(" ");
            input1 = ip[0];
            input2 = Integer.parseInt(ip[1]);

            String[] str = new String[input1.length()];
            for(int i=0; i<input1.length(); i++) str[i] = String.valueOf(input1.charAt(i));
            Arrays.sort(str); // 사전순으로

            count = 0; // 몇 번째 순열인지
            used = new boolean[str.length];
            result = new ArrayList<>();
            find(str, 0);
            if(count<input2) {
                System.out.print(input1+" "+input2+" = ");
                System.out.print("No permutation\n"); // 개행문자 없으면 틀렸다함
            }
        }
    }

    public static void find(String[] str, int index){
        if(str.length==index) {
            // 문자 다 선택함
            count++;
            if(count==input2){
                System.out.print(input1+" "+input2+" = ");
                for (String s : result) System.out.print(s);
                System.out.println();
            }
            return;
        }
        for(int i=0; i<str.length; i++){
            if(!used[i]) {
                used[i] = true;
                result.add(str[i]);
                find(str, index+1);
                result.remove(result.size()-1);
                used[i] = false;
            }
        }
    }
}
