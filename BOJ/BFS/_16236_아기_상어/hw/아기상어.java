import java.util.*;
public class Main {
    static class Position {
        int x;
        int y;
        int dist;

        Position(){}

        Position(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }
    }

    static int n;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        Position baby = new Position();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 9) {    //아기상어 위치 기록
                    baby.setX(i);
                    baby.setY(j);

                    arr[i][j] = 0;
                }
            }
        }
        System.out.print(solution(baby));
    }

    private static int solution(Position baby) {
        int size = 2;    //아기상어 처음 크기
        int eat_fish_count = 0; //먹은 물고기 수
        int time = 0;

        while(true) { //먹을 수 있는 물고기가 없을 때 까지 반복
            int[][] dist = bfs(baby, size); //아기상어부터 각 칸들까지의 거리배열 구하기

            // 먹을 수 있는 물고기 최소거리
            int min_distance = Integer.MAX_VALUE;

            // 먹을 수 있는 물고기 갱신해나가기.
            Position eat_fish = new Position();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[i][j] != 0 && arr[i][j] < size) {  //먹을 수 있는 물고기 라면.
                        int distance = dist[i][j];   //해당 물고기까지의 거리

                        if(distance < min_distance) {   //현재 물고기가 그 전 물고기의 거리보다 가깝다면
                            //최소 거리 갱신, 먹을 물고기 갱신
                            min_distance = distance;
                            eat_fish.setX(i);
                            eat_fish.setY(j);
                            eat_fish.setDist(distance);
                        } else if(min_distance == distance) {   //거리가 같다면
                            if(i < eat_fish.x) {    // 더 위쪽에 위치한 물고기로 갱신
                                eat_fish.setX(i);
                                eat_fish.setY(j);
                            } else if(i == eat_fish.x) { //위쪽이 같다면
                                if(j < eat_fish.y) {    // 더 왼쪽에 위치한 물고기로 갱신
                                    eat_fish.setX(i);
                                    eat_fish.setY(j);
                                }
                            }
                        }
                    }
                }
            }

            if(min_distance == Integer.MAX_VALUE) break;   //먹을 수 있는 물고기가 없다면 종료.

            arr[eat_fish.x][eat_fish.y] = 0;    //먹어치우기(해당 물고기 위치 0으로 바꾸기)
            eat_fish_count++;   //먹은 물고기 수 증가
            time += eat_fish.dist;  //먹은 물고기의 거리만큼 시간 증가
            //아기상어 위치 이동
            baby.setX(eat_fish.x);
            baby.setY(eat_fish.y);
            if(eat_fish_count == size) {    //먹은 물고기의 수가 아기상어 몸집과 같다면.
                eat_fish_count = 0;
                size++;
            }
        }//end of while--
        return time;
    }

    private static int[][] bfs(Position baby, int size) {
        int[][] dist = new int[n][n];
        Queue<Position> queue = new LinkedList<>();
        queue.offer(baby);
        int[][] visited = new int[n][n];
        visited[baby.x][baby.y] = 1;

        while(!queue.isEmpty()) {
            Position pos = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                // nx,ny가 arr의 범위를 넘지 않고, 방문체크, 사이즈가 작거나 같다면 지나갈 수 있는것임
                if(nx>=0 && nx<n && ny>=0 && ny<n && visited[nx][ny] == 0 && arr[nx][ny] <= size) {
                    visited[nx][ny] = 1;
                    dist[nx][ny] = dist[pos.x][pos.y] + 1;
                    queue.offer(new Position(nx, ny, pos.dist + 1));
                }
            }
        }
        return dist;
    }
}
