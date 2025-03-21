import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int result = 0;

        if(n >= k) result = n-k;
        else{
            result = solution(n, k);
        }

        System.out.println(result);
        
        br.close();
    }

    private static int solution(int n, int k){
        int[] times = new int[100001]; // 100,000 + 1
        
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);

        while(!queue.isEmpty()){
            int length = queue.size();

            for(int i=0; i<length; i++){
                int current = queue.poll();
                if(current == k) {
                    return times[current];
                }

                if(current + 1 <= 100000 && times[current+1] == 0) {
                    times[current+1] = times[current] + 1;
                    queue.add(current+1);
                }
                if(current -1 >= 0 && times[current-1] == 0) {
                    times[current-1] = times[current] + 1;
                    queue.add(current-1);
                }
                if(current * 2 <= 100000 && times[current * 2] == 0) {
                    times[current*2] = times[current] + 1;
                    queue.add(current*2);
                }

                // for(int j = 1; j<=18; j++){
                //     System.out.print(times[j] + " ");   
                // }
                // System.out.println("\n\n");
                
            }
        }

        return -1;
    }
}