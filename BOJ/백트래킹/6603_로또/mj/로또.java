package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 로또 {

    static ArrayList<Integer> result;
    static int[] arr;
    static int N;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = br.readLine()).equals("0")){
            String[] tmp = input.split(" ");
            N = Integer.parseInt(tmp[0]);
            arr = new int[N];
            for(int i = 0; i<N; i++){
                arr[i] = Integer.parseInt(tmp[i+1]);
            }
            Arrays.sort(arr);
            used = new boolean[N];
            result = new ArrayList<>();
            find(0,0);
            System.out.println();
        }
    }

    public static void find(int index, int lastIndex){
        if(index==6) {
            for(int i=0; i<6; i++) System.out.print(result.get(i)+ " ");
            System.out.println();
            return;
        }

        for(int i=lastIndex; i<N; i++){
            if(!used[i]){
                used[i] = true;
                result.add(arr[i]);
                find(index+1,i);
                used[i] = false;
                result.remove(result.size()-1);
            }
        }

    }
}
