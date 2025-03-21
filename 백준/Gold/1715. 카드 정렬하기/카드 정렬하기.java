import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(br.readLine().trim()));
        }
        
        if (n == 1) {
            System.out.println(0); // 묶음이 1개면 비교 불필요
        } else {
            long result = 0;
            while (pq.size() > 1) {
                long sum = pq.poll() + pq.poll();
                result += sum;
                pq.add(sum);
            }
            System.out.println(result);
        }
        
        br.close();
    }
}