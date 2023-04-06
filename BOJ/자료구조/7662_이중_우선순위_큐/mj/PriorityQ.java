package LastWeekMarch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class PriorityQ {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        TreeMap<Integer,Integer> tree = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            int k = Integer.parseInt(br.readLine());
            tree.clear();
            sb.setLength(0);
            for(int j=0; j<k; j++){
                String input = br.readLine();
                int num = Integer.parseInt(input.split(" ")[1]);

                if(input.contains("D ") && tree.size()>0){
                    int removeNum = (num==1) ? tree.lastKey() : tree.firstKey();
                    if(tree.get(removeNum)>1){
                        tree.replace(removeNum,tree.get(removeNum)-1);
                    }
                    else tree.remove(removeNum);
                }
                else if (input.contains("I ")){
                    if(tree.containsKey(num)) {tree.replace(num,tree.get(num)+1);}
                    else tree.put(num,1);
                }
            }
            if(tree.isEmpty()) {
                sb.append("EMPTY");
            }
            else{
                sb.append(tree.lastKey());
                sb.append(" ");
                sb.append(tree.firstKey());
            }
            System.out.println(sb);
        }
    }
}
