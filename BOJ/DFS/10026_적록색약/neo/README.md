## Info
<a href="https://www.acmicpc.net/problem/10026" rel="nofollow">10026_적록색약</a>

## ❗ 풀이 방법
1. 처음에 인풋값을 받을 때, 색맹이 없는 배열과 색맹이 있는 배열을 구분해서 받는다.
2. arr1 (색맹 X)는 그대로 배열을 받고, String.replaceAll 메서드를 사용해 G를 모두 R로 치환한 뒤에 arr2에 저장한다.
3. 그리고 색맹이 없는 사람이 보는 구역과 색맹이 있는 사람이 보는 구역을 각각 dfs 돌린 다음에 answer를 구하면 된다.

## 🙂 새로 알게된 점

* 

