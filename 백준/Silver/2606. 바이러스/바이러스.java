import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int result = 0;
    static boolean[] visited;
    static List<List<Integer>> list;
    static int n;
    static int m;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>()); // 1번컴퓨터부더
        }
        visited = new boolean[n+1];

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.get(first).add(second);
            list.get(second).add(first);
        }

        visited[1] = true;
        DFS(1);

        System.out.println(result-1);

        br.close();
    }

    private static void DFS(int start){
        result++;
        for(int value : list.get(start)){
            if(!visited[value]){
                visited[value] = true;
                DFS(value);
            }
        }
    }
}