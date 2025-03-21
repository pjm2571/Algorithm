import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int [n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int result = solution();

        System.out.println(result);
        
        br.close();
    }

    private static int solution(){
        int lt = 0;

        int sum = 0;
        int count = 0;

        int result = Integer.MAX_VALUE;

        for(int rt = 0; rt < n; rt++){
            sum += arr[rt];
            count++;
            if(sum >= m) {
                result = Math.min(result, count);
                while(sum >= m){
                    sum -= arr[lt++];
                    count--;
                    if(sum >= m) result = Math.min(result, count);
                }
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
  
}