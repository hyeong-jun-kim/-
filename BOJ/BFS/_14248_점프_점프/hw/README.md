## Info
<a href="https://www.acmicpc.net/problem/14248" rel="nofollow">14248_점프_점프</a>

## ❗ 풀이 방법
1. main에서 입력받기
2. solution함수에서 bfs 돌리기
3. 시작위치를 queue에 넣고 방문처리 시킨다음 bfs
4. queue에서 하나 꺼낸 위치를 current_pos로 놓는다(현재위치). 
5. 왼쪽 이동한 거리 = 현재위치 - 현재위치에 써있는 번호current_pos - arr[current_pos]
6. 오른쪽 이동한 거리 = 현재위치 + 현재위치에 써있는 번호current_pos + arr[current_pos]
7. 왼쪽 이동한 거리가 돌다리 범위 내 라면 방문처리
8. 오른쪽 이동한 거리가 돌다리 범위 내 라면 방문처리
9. 다시 solution 함수로 돌아가서 방문처리 된 곳 갯수 세서 return

## 🙂 새로 알게된 점

* 너무 쉬운 bfs 문제여서 새로 알게된 점은 없는 것 같다. 다만 왼쪽 이동한 거리와 오른쪽 이동한 거리를 따로 생각해야 되었던 점만 조금 다른정도..

