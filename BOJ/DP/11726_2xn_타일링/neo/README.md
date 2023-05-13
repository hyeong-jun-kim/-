## Info
<a href="https://www.acmicpc.net/problem/1926" rel="nofollow">1146_지름길</a>

## ❗ 풀이 방법
- 직접 그림을 그리면서 점화식을 구해보면 된다

![image1](https://hackmd.io/_uploads/r1bsTm6V2.png)

![image2](https://hackmd.io/_uploads/HJnjp7aVh.png)

- 해당 그림을 그려보면 dp[i] = dp[i-2] + dp[i-1]이 성립한다는 것을 알 수 있다.
- 이는 n이 3 이상인 경우, n-2인 경우의 수에다가 가로가 2인 사각형을 붙히고, n-1인 경우에 수에다가 세로가 1인 사각형을 붙혀서 더한 값이라는 것을 알 수 있다.

## 🙂 새로 알게된 점

- 직접 그림을 그려서 점화식을 도출하는 방법을 알게되었다.

