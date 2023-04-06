package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1905_상자_쌓기 {
    static class Box implements Comparable<Box> {
        int x1;
        int x2;
        int y1;
        int y2;
        long height;

        public Box(int x1, int lx, int y1, int ly) {
            this.x1 = x1;
            this.x2 = x1 + lx;
            this.y1 = y1;
            this.y2 = y1 + ly;
        }

        public Box(int x1, int lx, int y1, int ly, long height) {
            this.x1 = x1;
            this.x2 = x1 + lx;
            this.y1 = y1;
            this.y2 = y1 + ly;
            this.height = height;
        }

        // 겹치는 영역이 있는지 확인하는 메서드
        public long getOverlapArea(Box b) {
            int xOverlap = Math.max(0, Math.min(this.x2, b.x2) - Math.max(this.x1, b.x1));
            int yOverlap = Math.max(0, Math.min(this.y2, b.y2) - Math.max(this.y1, b.y1));
            return (long) xOverlap * yOverlap;
        }

        public boolean isDuplicatedArea(Box b) {
            long overlap = getOverlapArea(b);
            return overlap > 0;
        }

        public void setHeight(long height) {
            this.height = height;
        }

        @Override
        public int compareTo(Box box) {
            return box.height > this.height ? 1 : -1;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long maxHeight = Integer.MIN_VALUE;
        ArrayList<Box> boxList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int lz = Integer.parseInt(st.nextToken());
            int px = Integer.parseInt(st.nextToken());
            int py = Integer.parseInt(st.nextToken());

            boolean check = false;
            Box defaultBox = new Box(px, lx, py, ly);

            if(i == 0){
                maxHeight = lz;
            }

            long tmpMax = Integer.MIN_VALUE;
            for (int j = 0; j < boxList.size(); j++) {
                // 사각형의 꼭짓점 4개 구하기
                Box b = boxList.get(j);
                if(tmpMax < b.height){
                    if (defaultBox.isDuplicatedArea(b)) {
                        tmpMax = b.height;
                        check = true;
                        if (tmpMax + lz >= maxHeight){
                            maxHeight = b.height + lz;
                        }
                    }
                }
            }

            if (!check) {
                boxList.add(new Box(px, lx, py, ly, lz));
                maxHeight = Math.max(maxHeight, lz);
            }
            else{
                defaultBox.setHeight(tmpMax + lz);
                boxList.add(defaultBox);
            }
        }

        System.out.println(maxHeight);
    }
}