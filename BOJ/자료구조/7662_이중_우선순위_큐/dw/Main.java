import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (order.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (num == 1) {
                        if(!map.isEmpty()) {
                            if (map.get(map.lastKey()) == 1) {
                                map.remove(map.lastKey());
                            } else {
                                map.put(map.lastKey(), map.get(map.lastKey()) - 1);
                            }
                        }
                    } else {
                        if(!map.isEmpty()) {
                            if (map.get(map.firstKey()) == 1) {
                                map.remove(map.firstKey());
                            } else {
                                map.put(map.firstKey(), map.get(map.firstKey()) - 1);
                            }
                        }
                    }
                }
            }
            if(map.isEmpty()){
                System.out.println("EMPTY");
            }else{
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
            map.clear();
        }
    }
}