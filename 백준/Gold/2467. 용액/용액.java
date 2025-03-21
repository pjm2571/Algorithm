import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int lt = 0;
        int rt = arr.length -1;

        int result = Integer.MAX_VALUE;
        int first = 0;
        int second = 0;

        while(lt < rt){
            int sum = arr[lt] + arr[rt];
            if(Math.abs(sum) < Math.abs(result)){
                result = sum;
                first = arr[lt];
                second = arr[rt];
            }
            if(sum < 0) lt++;
            else if(sum > 0) rt--;
            else break;
        }

        System.out.println(first + " " + second);

        br.close();
    }
}