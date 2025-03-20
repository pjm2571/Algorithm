import java.util.*;
import java.lang.*;
import java.io.*;

class Position {
    int row;
    int col;
    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Main {
    static int n;
    static int m;
    
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    static int[][] board;
    static int[][] distance;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n+1][m+1];
        distance = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            String input = br.readLine();
            for(int j=1; j<=m; j++){
                board[i][j] = input.charAt(j-1) - '0';
            }
        }

        BFS();

        System.out.println(distance[n][m]);
        
        br.close();
    }

    private static void BFS(){
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(1, 1)); // 첫번째 위치를 입력
        distance[1][1] = 1; // 처음 가는 경우는 1
        while(!queue.isEmpty()){
            Position current = queue.poll();
            for(int i =0; i<4; i++){
                int nRow = current.row + dRow[i];
                int nCol = current.col + dCol[i];
                if(nRow > 0 && nRow <=n && nCol > 0 && nCol <= m && board[nRow][nCol] == 1){
                    board[nRow][nCol] = 0; // 방문 처리
                    distance[nRow][nCol] = distance[current.row][current.col] + 1; // 현재 위치에서 1 더해준다.
                    queue.add(new Position(nRow, nCol)); // 해당 지점을 또다시 queue에 넣음
                }
            }
        }
    }
}