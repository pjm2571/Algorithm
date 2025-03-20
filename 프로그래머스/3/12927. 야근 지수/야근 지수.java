import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        for(int i=0; i<n; i++){
            pq.add(pq.poll() -1);
        }        
        
        long sum = 0;
        while(!pq.isEmpty()){
            int value = pq.poll();
            if(value > 0){
                sum += Math.pow(value, 2);
            }
        }
        
        return sum;
    }
}