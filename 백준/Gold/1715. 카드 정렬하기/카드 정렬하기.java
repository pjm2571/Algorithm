import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            pq.add((long)(Integer.parseInt(br.readLine())));
        }

        if(n==1){
            System.out.println(0);
        }
        else{
            long result = 0;
            while(pq.size() != 1){
                long sum = pq.poll() + pq.poll();
                result += sum;
                pq.add(sum);
            }
            System.out.println(result);
        }
        
        br.close();
    }
}