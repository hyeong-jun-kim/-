## Info
<a href="https://www.acmicpc.net/problem/1926" rel="nofollow">1926_그림</a>

## ❗ 풀이 방법
1. n, m번 만큼 for문을 돌면서, arr[i][j]가 1이고, visited[i][j] == false이면 해당 점을 기준으로 상,하,좌,우 dfs를 돌린다.
2. dfs 돌 때, 새로운 점을 방문할 때마다 tmp + 1을 해주고, width = Math.max(width, tmp)를 통해 제일 큰 넓이를 저장하게 한다.
3. for문을 돌 때마다 새로운 점에 방문하면, cnt + 1을 해줘서 사진의 크기를 구한다.

## 🙂 새로 알게된 점

* 

