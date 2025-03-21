import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 10000); // 초기값을 큰 수로 설정
        arr[0] = 0;  // 0은 0번 연산
        if (n >= 3) arr[3] = 1;  // 3은 1번 연산
        if (n >= 5) arr[5] = 1;  // 5는 1번 연산

        // DP로 모든 경우 계산
        for (int i = 6; i <= n; i++) {
            arr[i] = Math.min(arr[i], Math.min(arr[i - 3], arr[i - 5]) + 1);
        }

        System.out.println(arr[n] >= 10000 ? -1 : arr[n]);
        br.close();
    }
}
