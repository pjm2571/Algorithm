import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] board = new int[101];
    static int n;
    static int m;
    static Map<Integer, Integer> ladders;
    static Map<Integer, Integer> snakes;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        ladders = new HashMap<>();

        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            ladders.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        snakes = new HashMap<>();

        for(int i=0; i<m; i++){
            input = br.readLine().split(" ");
            snakes.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        solution();

        System.out.println(board[100]);

        br.close();
    }

    private static void solution() {
        int start = 1; // 1번부터 시작

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        int roll = 1;

        while(!queue.isEmpty()){
            int length = queue.size();

            for(int i=0; i<length; i++){
                
                int now = queue.poll(); // 현재 큐에 저장되어 있는 시작점을 가지고 옴

                // System.out.println("now : " + now);
                
                for(int j=1; j<=6; j++){
                    int next = now+j;

                    if(next > 100) break;
                    
                    if(board[next] != 0) continue;

                    // System.out.println(next);

                    if(snakes.containsKey(next)) {
                        int dest = snakes.get(next);
                        if(board[dest] == 0){
                            queue.add(dest);
                            board[dest] = roll;
                        }
                        continue;
                    } 

                    if(ladders.containsKey(next)) {
                        int dest = ladders.get(next);
                        if(board[dest] == 0){
                            queue.add(dest);
                            board[dest] = roll;
                        }
                        continue;
                    }

                    if(board[next] == 0) {
                        board[next] = roll;
                        queue.add(next);
                    }
                }
            }

            roll++; // 굴리기 횟수 1 증가
        }

    }
}