package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분수열의합 {

    static int N;
    static int S;
    static int[] arr;
    static boolean[] used;
    static int sum;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        arr = new int[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]);
        count=0;

        int pickNums = 1;
        while(pickNums <= N){  // 1개뽑기, 2개뽑기, 3 .. N개 뽑기
            used = new boolean[N];
            sum = 0;
            find(pickNums, 0, -1);
            pickNums++;
        }

        System.out.println(count);
    }

    public static void find(int pickNums, int index, int lastInsert){
        // 부분수열의 원소가 pickNums개
        // index 번째 숫자 뽑는 중
        if(index==pickNums && S==sum) count++;
        if(index==pickNums) return;

        // 전체 원소 수만큼 뽑을 거면 그냥 다 더해서 계산해보기
        if(pickNums==N){
            for(int i=0; i<N; i++){
                sum+=arr[i];
            }
            if(sum==S) count++;
            return;
        }

        for(int i=lastInsert+1; i<N; i++){
            if(!used[i]) {
                used[i] = true;
                sum+=arr[i];
                find(pickNums, index+1, i);
                used[i]=false;
                sum-=arr[i];
            }
        }

    }
}
