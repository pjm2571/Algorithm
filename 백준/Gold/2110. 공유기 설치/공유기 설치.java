import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());   
        }

        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[arr.length-1];

        int result = Integer.MIN_VALUE;

        while(lt <= rt) {
            int distance = (lt + rt) / 2;

            int prev = arr[0];
            int count = 1;
            
            for(int i=1; i < n; i++){
                if(arr[i] - prev >= distance){
                    count++;
                    prev = arr[i];
                }
            }

            if(count >= c){
                lt = distance + 1;
                result = Math.max(result, distance);
            }else rt = distance - 1;
        }

        System.out.println(result);
        
        br.close();
    }
}