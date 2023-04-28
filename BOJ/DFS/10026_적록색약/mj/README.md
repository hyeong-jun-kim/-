## Info
<a href="https://www.acmicpc.net/problem/10026" rel="nofollow">10026_적록색약</a>

## ❗ 풀이 방법
1. 정상인: real, visible, dfs1, visited로 탐색
2. 색맹 : unreal(입력받을 때 G를 R로 통일), invisible, dfs2, visited
3. 상하좌우 중 아직 탐색하지 않았고, 같은 색인 부분을 찾고, 이어서 탐색할 수 있도록 함수 다시 불러오기(재귀)

## 🙂 새로 알게된 점

* 

