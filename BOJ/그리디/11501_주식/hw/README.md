## Info
<a href="https://www.acmicpc.net/problem/11501" rel="nofollow">11501_주식</a>

## ❗ 풀이 방법
1. main에서 테스트케이스의 갯수, 배열의길이, 배열 입력받고 solution으로 넘기기
2. solution에서 뒤에서부터 배열을 탐색하고, 현재가격이 max값보다 크다면 max값 갱신
3. max값보다 작다면 answer에 이익 (최대주가 - 현재가격)을 누적

## 🙂 새로 알게된 점

* 처음에 PriorityQueue로 풀었는데 테스트케이스는 통과하지만 정답으로 인정이 되지 않았다.. 결국에 반례는 못찾았는데 나중에라도 찾았으면 좋겠다..<br>
* 문제 유형이 그리디라는 것을 깨닫는다면 정렬,PriorityQueue,뒤에서부터 탐색 등을 떠올리면 대부분 풀 수 있는 것 같다.

