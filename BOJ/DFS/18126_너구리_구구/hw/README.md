## Info
<a href="https://www.acmicpc.net/problem/18126" rel="nofollow">18126_너구리 구구</a>

## ❗ 풀이 방법
1. main에서 값 입력받기
2. solution함수에서 1번방 방문처리 하고 dfs 호출
3. dfs가 호출될 때 마다 거리(dist)를 현재 넘어온 distance와 비교하여 최댓값으로 갱신. 이렇게 하면 1번방 -> vertex 까지의 거리가 최댓값으로 갱신된다.

## 🙂 새로 알게된 점

* 노드의 연결정보를 초기화 하고 dfs를 돌리는것에 익숙하지 않아서 살짝 헤맸던 것 같다. 연습필요!

