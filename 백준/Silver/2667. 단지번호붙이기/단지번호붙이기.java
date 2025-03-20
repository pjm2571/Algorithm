import java.util.*;
import java.lang.*;
import java.io.*;



class Main {
    static int n;
    static int[][] board;
    static int count;

    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        List<Integer> counts = new ArrayList<>();

        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<n; j++){
                board[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    count = 0;
                    board[i][j] = 0;
                    DFS(i, j);
                    counts.add(count);
                }
            }
        }

        System.out.println(counts.size());
        Collections.sort(counts);
        for(int v : counts){
            System.out.println(v);
        }
        

        br.close();
    }

    private static void DFS(int row, int col){
        count++;
        for(int i=0; i<4; i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < n && board[nRow][nCol] == 1){
                board[nRow][nCol] = 0;
                DFS(nRow, nCol);
            }
        }
    }
    
}