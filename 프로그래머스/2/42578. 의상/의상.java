// 22:18

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String category = clothes[i][1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        int result = 1;
        
        for(String category : map.keySet()){
            result *= (map.get(category) + 1);
        }
        
        return result - 1;
    }
}