import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[][] arr = new int[a][b];

        for(int i=0; i<a; i++) {
            for(int j=0; j<b; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(solution(a, b, arr));
    }

    private static int solution(int a, int b, int[][] arr) {
        int answer = Integer.MIN_VALUE;

        for(int i=0; i<a; i++) {
            for(int j=0; j<b; j++) {
                //1번 케이스 (i,j) (i, j+1) (i, j+2) (i, j+3)
                //2번 케이스 (i,j) (i, j+1) (i+1,j) (i+1,j+1)
                //3번 케이스 (i,j) (i+1, j) (i+2, j) (i+2, j+1)
                //4번 케이스 (i,j) (i+1, j) (i+1, j+1) (i+2, j+1)
                //5번 케이스 (i,j) (i, j+1) (i, j+2) (i+1, j+1)

                //1번케이스 계산하기
                if(j+3 < b) {
                    int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
                    answer = Math.max(answer, sum);
                }

                //1번 회전시킨 케이스 계산하기
                if(i+3 < a) {
                    int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];
                    answer = Math.max(answer, sum);
                }

                //2번케이스 계산하기
                if(i+1 < a && j+1 < b) {
                    int sum = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1];
                    answer = Math.max(answer, sum);
                }

                //3번케이스 계산하기
                if(i+2< a && j+1 < b) {
                    int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
                    answer = Math.max(answer, sum);
                }

                //3번 회전시킨 케이스 계산하기 1
                if(i+1 < a && j+2 < b) {
                    int sum = arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i][j+2];
                    answer = Math.max(answer, sum);
                }

                //3번 회전시킨 케이스 계산하기 2
                if(i+2 < a && j+1 < b) {
                    int sum = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
                    answer = Math.max(answer, sum);
                }

                //3번 회전시킨 케이스 계산하기 3
                if(i+1 < a && j-2 >= 0) {
                    int sum = arr[i][j] + arr[i+1][j] + arr[i+1][j-1] + arr[i+1][j-2];
                    answer = Math.max(answer, sum);
                }

                //4번케이스 계산하기
                if(i+2 < a && j+1 < b) {
                    int sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
                    answer = Math.max(answer, sum);
                }

                //4번 회전시킨 케이스 계산하기 1
                if(i-1 >= 0 && j+2 < b) {
                    int sum = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-1][j+2];
                    answer = Math.max(answer, sum);
                }

                //5번케이스 계산하기
                if(i+1 < a && j+2 < b) {
                    int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1];
                    answer = Math.max(answer, sum);
                }

                //5번 회전시킨 케이스 계산하기 1. ㅏ
                if(i+2 < a && j+1 < b) {
                    int sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j];
                    answer = Math.max(answer, sum);
                }

                //5번 회전시킨 케이스 계산하기 2. ㅗ
                if(i-1>=0 && j+2 < b) {
                    int sum = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i][j+2];
                    answer = Math.max(answer, sum);
                }

                //5번 회전시킨 케이스 계산하기 3. ㅓ
                if(i-1 >= 0 && i+1<a && j+1<b) {
                    int sum = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i+1][j+1];
                    answer = Math.max(answer, sum);
                }
            }
        }

        return answer;
    }
}
