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

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean[] visited = new boolean[n+1];

        int result = 0;

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                result++;
                DFS(i, list, visited);
            }
        }
        
        System.out.println(result);
        
        br.close();
    }

    private static void DFS(int index, List<List<Integer>> list, boolean[] visited){
        visited[index] = true;
        List<Integer> arr = list.get(index);
        for(int idx : arr){
            if(!visited[idx]) DFS(idx, list, visited);
        }
    }
}