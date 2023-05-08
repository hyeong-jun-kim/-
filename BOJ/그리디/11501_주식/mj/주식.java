package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식 {

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int[] arr = new int[n];
            for(int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int max = arr[n-1];
            int result=0;
            for(int k=n-2; k>=0;k--){
                if(max>arr[k]) result+=(max-arr[k]);
                else if(max<arr[k]) max = arr[k];
            }
            System.out.println(result);
        }
    }
}
