import java.io.*;
import java.util.*;

public class Main {
    static int[][] gear = new int[4][8]; //톱니바퀴 상태 저장
    static int[] dir; // 각 톱니바퀴의 방향정보 저장
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String[] str = bf.readLine().split("");
            for (int j = 0; j < 8; j++) {
                gear[i][j] = Integer.parseInt(str[j]);
            }
        }
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int order = Integer.parseInt(st.nextToken());
            dir = new int[4];
            dir[num] = order;
            checkDir(num);
            rotateGear();
        }
        System.out.println(calResult());
    }

    static void checkDir(int gearNum) {
        //gearNum 기준 좌측에있는 톱니바퀴 방향성 검사
        for (int i = gearNum - 1; i >= 0; i--) {
            if (gear[i][2] != gear[i + 1][6]) {
                dir[i] = -dir[i + 1];
            } else {
                break;
            }
        }

        //gearNum 기준 우측에있는 톱니바퀴 방향성 검사
        for (int i = gearNum + 1; i < 4; i++) {
            if (gear[i][6] != gear[i - 1][2]) {
                dir[i] = -dir[i - 1];
            } else {
                break;
            }
        }
    }

    static void rotateGear() {
        int tmp = 0;

        for(int i=0; i<4; i++) {
            //시계방향 회전
            if(dir[i] == 1) {
                tmp = gear[i][7];
                for(int j=7; j>0; j--) {
                    gear[i][j] = gear[i][j-1];
                }
                gear[i][0] = tmp;
            }
            //반시계방향회전
            if(dir[i] == -1) {
                tmp = gear[i][0];
                for(int j=0; j<7; j++) {
                    gear[i][j] = gear[i][j+1];
                }
                gear[i][7] = tmp;
            }
        }
    }

    static int calResult() {
        int result = 0;
        if (gear[0][0] == 1) {
            result += 1;
        }
        if (gear[1][0] == 1) {
            result +=2;
        }
        if (gear[2][0] == 1) {
            result += 4;
        }
        if (gear[3][0] == 1) {
            result += 8;
        }
        return result;
    }
}
