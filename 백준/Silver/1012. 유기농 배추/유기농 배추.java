import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    private static int[][] board;
    private static int row;
    private static int column;
    
    private static int[] dRow = {-1, 0, 1, 0};
    private static int[] dCol = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int test = 0; test < t; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            column = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
    
            board = new int[row][column];
    
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                board[r][c] = 1;
            }

            int result = solution(row, column);

            System.out.println(result);
        }
        br.close();
    }

    private static int solution(int row, int column){
        int result = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(board[i][j] == 1){
                    result++;
                    DFS(i, j); // 1인 부분을 모두 0 처리
                }
            }
        }
        return result;
    }

    private static void DFS(int r, int c){
        for(int i=0; i<4; i++){
            int nRow = r + dRow[i];
            int nCol = c + dCol[i];
            if(nRow >=0 && nRow < row && nCol >= 0 && nCol < column && board[nRow][nCol] == 1){
                board[nRow][nCol] = 0;
                DFS(nRow, nCol);
            }
        }
    }
}