import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<>();
        for(String[] arr : clothes){
            map.put(arr[1],map.getOrDefault(arr[1],0)+1);
        }
        int result =1;
        for(String key : map.keySet()){
            result *= map.get(key)+1;
        }
        return result -1;
    }
}