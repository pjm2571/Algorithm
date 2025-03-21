import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 오름차순으로 정렬

        int lt = 0; 
        int rt = arr[arr.length-1]; // 최대값 가져옴

        int result = Integer.MIN_VALUE;
        
        while(lt <= rt){
            int height = (lt + rt) / 2;

            long sum = 0;
            
            for(int i=0; i<n; i++){
                if(arr[i] > height) sum += (arr[i] - height);
            }

            if(sum >= m) {
                lt = height + 1;
                result = Math.max(result, height);
            }
            else rt = height - 1;
        }

        System.out.println(result);

        br.close();
    }
}