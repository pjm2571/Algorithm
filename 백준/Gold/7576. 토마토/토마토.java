import java.util.*;
import java.lang.*;
import java.io.*;

class Position{
    int row;
    int col;
    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[][] board = new int[row][column];

        Queue<Position> queue = new LinkedList<>();
        
        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<column; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) queue.add(new Position(i, j));
            }
        }

        int result = solution(row, column, board, queue);

        System.out.println(result);
        
        br.close();
    }

    private static int solution(int rowLimit, int colLimit, int[][] board, Queue<Position> queue){
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        int days = 0;
        
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0; i<length; i++){
                Position current = queue.poll();
                for(int j=0; j<4; j++){
                    int nRow = current.row + dRow[j];
                    int nCol = current.col + dCol[j];
                    if(nRow >= 0 && nRow < rowLimit && nCol >= 0 && nCol < colLimit && board[nRow][nCol] == 0){
                        board[nRow][nCol] = 1;
                        queue.add(new Position(nRow, nCol));
                    }
                }
            }
            days++;
        }

        for(int i=0; i<rowLimit; i++){
            for(int j=0; j<colLimit; j++){
                if(board[i][j] == 0) return -1;
            }
        }

        return days-1;
    }
}