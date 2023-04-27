package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 추천 시작하기 전에는 모든 사진틀 비어있음
// 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 함
// 비어있는 사진틀이 없을 경우, 추천 받은수가 가장 적은 학생의 사진을 삭제하고 그자리에 새롭게 추천받은 학생의 사진을 게시한다.
// 만약 가장 적은 학생이 두 명 이상이면 그 중 가장 오래된 사진을 삭제한다
// 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우 추천받은 횟수만 증가시킨다
// 사진틀에 게시된 사진이 삭제된 경우는 해당 학생이 추천받은 횟수는 0으로 바뀐다

// 사진틀에 사진이 게재된 최종 후보의 학생 번호를 증가하는 순서대로 출력한다
public class _1713_후보_추천하기 {
    static class Student implements Comparable<Student>{
        int idx;
        int number;
        int count;

        public Student(int idx, int number){
            this.idx = idx;
            this.number = number;
            this.count = 1;
        }

        public void setCount(int count){
            this.count = count;
        }

        @Override
        public int compareTo(Student student){
            if(this.count == student.count)
                return this.idx - student.idx;

            return this.count - student.count;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        PriorityQueue<Student> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        loop:
        for(int i = 0; i < m; i++){
            int stuNum = Integer.parseInt(st.nextToken());

            // 큐 안에 해당 학생 있으면 카운트 + 1
            Iterator<Student> iter = pq.iterator();
            while(iter.hasNext()){
                Student s = iter.next();
                if(s.number == stuNum){
                    pq.remove(s);
                    int count = s.count + 1;
                    s.setCount(count);
                    pq.offer(s);
                    continue loop;
                }
            }

            // 큐 안에 해당 학생 존재 X -> 큐 사이즈 확인
            if(pq.size() == n){
                pq.poll(); // 제일 우선순위 낮은 학생 제거
            }
            pq.offer(new Student(i, stuNum));
        }

        // 출력
        ArrayList<Integer> list = new ArrayList<>();
        for(Student s : pq)
            list.add(s.number);

        Collections.sort(list);

        for(int a : list)
            System.out.print(a + " ");
    }
}