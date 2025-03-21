import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int[] arr = new int[k];

        int max = 0;
        
        for(int i=0; i<k; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long lt = 1; // 최소 길이는 1 (0은 불가능)
        long rt = max; // 최대 길이
        long result = 0;
        
        while(lt <= rt){
            long length = (lt + rt) / 2;
            
            long sum = 0; 
            
            for(int v : arr){
                sum += (v / length);
            }

            if (sum >= n) {
                lt = length + 1;
                result = Math.max(result, length);
            }
            else rt = length -1;
        }

        System.out.println(result);

        br.close();
    }
}