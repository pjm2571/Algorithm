import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<participant.length; i++){
            String name = participant[i];
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for(int i=0; i<completion.length; i++){
            String name = completion[i];
            map.put(name, map.get(name) -1);
            if(map.get(name)== 0) map.remove(name);
        }
        
        String result = "";
        for(String key : map.keySet()){
            result = key;
        }
        
        return result;
    }
}