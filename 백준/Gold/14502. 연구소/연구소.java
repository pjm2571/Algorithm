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

    @Override
    public String toString(){
        return String.format("(%d, %d)", row, col);
    }
}

class Main {
    static int[][] lab;
    static int row;
    static int column;
    static Queue<Position> viruses;

    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    static int result = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        row = Integer.parseInt(input[0]);
        column = Integer.parseInt(input[1]);
        viruses = new LinkedList<>();

        lab = new int[row][column];

        List<Position> availables = new ArrayList<>();

        for(int i=0; i<row; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<column; j++){
                int value = Integer.parseInt(st.nextToken());
                lab[i][j] = value;
                if(value == 0) availables.add(new Position(i, j)); // 빈 공간 넣기
                if(value == 2) viruses.add(new Position(i, j)); // 바이러스 넣기
            }
        }

        Position[] combination = new Position[3];

        combi(0, 0, availables, combination);

        System.out.println(result);
        
        br.close();
    }

    private static void combi(int level, int startIndex, List<Position> availables, Position[] combination){
        if(level == 3){
            calculate(combination);
            return;
        }
        else{
            for (int i = startIndex; i < availables.size(); i++) {
                combination[level] = availables.get(i); // 현재 level에 i번째 요소를 넣음
                combi(level + 1, i + 1, availables, combination); // 다음 레벨로 이동, 중복 방지를 위해 i+1
            }
        }
    }

    private static void calculate(Position[] combination){

        // 원본 lab 2차원 배열 복사
        int[][] copyLab = new int[row][column];

        for(int i=0; i<row; i++){
            copyLab[i] = lab[i].clone();
        }

        // 조합대로 벽 세우기
        for(Position p : combination){
            copyLab[p.row][p.col] = 1;
        }

        Queue<Position> queue = new LinkedList<>(viruses);

        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0; i<length; i++){
                Position current = queue.poll();

                for(int j=0; j<4; j++){
                    int nRow = current.row + dRow[j];
                    int nCol = current.col + dCol[j];
                    if(nRow >= 0 && nRow < row && nCol >= 0 && nCol < column && copyLab[nRow][nCol] == 0){
                        copyLab[nRow][nCol] = 2;
                        queue.add(new Position(nRow, nCol));
                    }
                }
            }
        }


        int sum = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(copyLab[i][j] == 0) sum++;
            }
        }

        result = Math.max(result, sum);
    }
}