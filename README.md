## 알고리즘 스터디 😎
2023년 상반기에 진행하는 자바 알고리즘 스터디 관련 레포지토리 입니다.

### 진행 기간
2023년 3월 25일 ~ 

### 모임 시간
매주 금요일 강남역 스터디 룸 오후 3시 ~ 오후 6시

### 일정
* 1주차 (3/25~3/31): 자료구조

### 문제집
<details>
<summary>1주차 - 자료구조</summary>
1. [백준/Gold4] 이중 우선순위 큐 - https://www.acmicpc.net/problem/7662 <br>
2. [백준/Silver2] 괄호의 값 - https://www.acmicpc.net/problem/2504 <br>
3. [프로그래머스/LEVEL2] 위장 - https://school.programmers.co.kr/learn/courses/30/lessons/42578 <br>
4. [백준/Gold5] 탑 - https://www.acmicpc.net/problem/2493 <br>
</details>

### 디렉토리 구조
출제사이트/유형/문제번호_제목/닉네임
```
ex) BOJ/자료구조/7662_이중_우선순위_큐/neo
```

## Github 규칙
### 기본 규칙
1. 매주 금요일 스터디 직후, 다음주 진행할 문제의 유형이 정해지면 한 사람이 새로운 유형 폴더를 만든다.
2. main 브랜치에서 본인의 이름으로 각자 브랜치를 새로 생성하고 매주마다 최신 메인 브랜치로 pull 받는다.
3. 본인 브랜치에 커밋 & 푸시 후, 메인 브랜치로 PR을 올린다.
4. 메인 브랜치의 PR은 스터디원 전원이 코드리뷰를 거쳐 Approved를 해야지 올라가며, 매주 스터디때 코드를 검토하도록 한다. <br>
 4-1. 만약, 코드리뷰를 진행했는데 질문이 있거나 피드백을 주고싶은 것이 있다면 자유롭게 comment 남겨도 된다.

### PR 규칙
* PR 제목은 `[해당 주]-[본인 닉네임]` 으로 한다.
* merge base가 main임을 확인한다.
* 덧붙힐 코멘트가 있으면 자유롭게 입력해도 된다.

### Commit Convention
**새로운 파일 생성 시**: `[CREATE] 알고리즘 사이트 / 문제 번호 / 문제 이름` <br>
만약에, 문제 번호가 없을 시에는 생략하도록 한다. <br> 
```
ex) [CREATE] 백준 2493 - 탑, [CREATE] 프로그래머스 자료구조 - 위장
```
**기존 파일 수정 시 :**: `[MODIFY] 알고리즘 사이트 / 문제 번호 / 문제 이름` <br>
```
ex) [MODIFY] 백준 2493 - 탑, [MODIFY] 프로그래머스 자료구조 - 위장
```

### 코드 설명 방법
template.md를 참고하여 문제 풀이 코드와 동일한 폴더에 README.md를 작성하고 올린다.

## Git 사용법
### 초기 세팅
```
1. git clone "https://github.com/hyeong-jun-kim/Algorithm_Study" -> git clone 명령어는 해당 레포를 복제하는 명령어이다.
2. cd Algorithm_Study -> 알고리즘 스터디 폴더로 이동하는 명령어이다.
3. git checkout 자기닉네임 -> 예를 들어서, git checkout neo를 입력하면 neo remote 브랜치에서 작업을 진행한다는 뜻이다.
```

### 자신의 브랜치로 push하기
문제를 풀었거나, 문제의 readme.md를 작성했을 때는 커밋 및 푸시를 해야한다.
```
1. git add . - 변경 사항들을 저장하는 명령어이다.
2. git commit -m "메시지이름" -> 커밋 메시지를 입력하는 명령어이다. 메시지이름은 위의 Commit Convention을 적용해서 작성해주면 된다.
3. git push -> 자신의 브랜치로 올리는 명령어이다.
```

### main 브랜치 pull 받기
main 브랜치에 새로운 폴더가 생겨나면 pull 받아야한다.
```
1. git pull origin main -> main 브랜치를 pull 받는 명령어이다. 만약 오류가 날 경우 git remote add origin "https://github.com/hyeong-jun-kim/Algorithm_Study"를 해주자
```

### PR 올리기
스터디를 진행하기 전에 코드를 검토받기 위해 Pull Request를 올려야한다. <br>
Pull Request를 올릴 때는 해당 주차에 푼 문제를 포함해야 하며, PR 제목은 *[해당 주]-[본인 닉네임]* 으로 한다.
```
1. 해당 깃헙 레포 -> 상단에 Pull Request 클릭 -> New Pull request -> compare 자신의 브랜치, base main 브랜치 확인 -> PR 제목 입력 -> Create Pull Request 클릭
```

### PR 검토
다른 사람이 올린 PR을 검토할 수 있다. PR은 `2개 이상의 approved`를 받아야 main 브랜치로 merge된다. <br>
또한 궁금한 점이 있을 경우 approved 대신에 **comment를 달아서 start a reivew**를 진행할 수 있다.
