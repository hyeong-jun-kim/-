## Info
<a href="https://www.acmicpc.net/problem/9742" rel="nofollow">9742_순열</a>

## ❗ 풀이 방법
- 백트래킹 문제이다. 하나의 조합마다 cnt+1을 하고, k에 도달했을 경우 해당 조합을 출력하면 된다.
- 어려웠던 점은 문제에서 테스트 케이스의 수를 제시해주지 않아 EOF 처리를 해야되는데 처음 해봐서 어려웠다.
    - 의아한 점은 BufferedReader로는 EOF 처리가 되나 StringTokenizer로는 되지 않는다는 점이다.. 아직까지 잘 모르겠다

## 🙂 새로 알게된 점
- 테스트 케이스의 갯수가 안주여저도 BufferedReader로 EOF 처리를 하는 방법에 대해서 알게되었다.

