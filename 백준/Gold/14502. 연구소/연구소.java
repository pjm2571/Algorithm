import java.util.*;
import java.lang.*;
import java.io.*;

class Position {
    
    int row;
    int column;

    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }
    
}


class Main {
    static int n; // 입력된 row 값
    static int m; // 입력된 column 값
    
    static int[][] lab; // row * column으로 이루어진 연구소

    static List<Position> availables; // 빈 공간 = 벽을 세울 수 있는 곳들 전체 리스트
    
    static Queue<Position> viruses; // 바이러스가 들어있는 위치 -> bfs에서 사용하기 위해 queue로 선언

    static Position[] combination; // 3개로 만들 수 있는 position 조합

    static int[] dRow = {-1, 0, 1, 0}; // 12 3 6 9 방향
    static int[] dCol = {0, 1, 0, -1}; // 12 3 6 9 방향

    static int result = Integer.MIN_VALUE; // result를 저장하기 위한 값 -> 최대값을 구해야하므로 min으로 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];

        availables = new ArrayList<>();
        viruses = new LinkedList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int value = Integer.parseInt(st.nextToken());
                lab[i][j] = value;
                if(value==0) availables.add(new Position(i, j)); // 빈 공간인 경우 list에 넣음
                if(value==2) viruses.add(new Position(i, j)); // 바이러스인 경우 queue에 넣음
            }
        }

        combination = new Position[3]; // 3개로 만들 수 있는 조합 생성

        makeCombination(0, 0); // level, startIndex

        System.out.println(result);

        br.close();
    }

    private static void makeCombination(int level, int startIndex){
        if(level == 3){
            calculate();
            return;
        }    
        else{
            for(int i = startIndex; i < availables.size(); i++){
                combination[level] = availables.get(i); // 조합에 position 할당
                makeCombination(level + 1, i + 1); // dfs로 조합 생성
            }
        }
    }

    private static void calculate(){
        int[][] copyLab = new int[n][m]; // 원본 배열을 보존하기 위한 복사본 생성

        for(int i=0; i<n; i++){
            copyLab[i] = lab[i].clone(); // 각각의 행에 대한 배열을 복사! -> 깊은 복사
        }

        for(Position p : combination){
            copyLab[p.row][p.column] = 1; // 조합에 해당하는 위치에 벽을 세운다
        }

        Queue<Position> queue = new LinkedList<>(viruses); // 바이러스들을 가지고 있는 큐 생성

        while(!queue.isEmpty()){
            int length = queue.size();

            for(int i=0; i<length; i++){
                Position current = queue.poll(); // 현재 바이러스가 있는 위치를 가져온다.

                for(int j=0; j<4; j++){
                    int nRow = current.row + dRow[j];
                    int nCol = current.column + dCol[j];
                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && copyLab[nRow][nCol] == 0){ // 범위 내 + 빈 공간 이라면
                        copyLab[nRow][nCol] = 2; // 해당 공간을 바이러스가 잠식
                        queue.add(new Position(nRow, nCol)); // 새로운 바이러스 공간을 queue에 추가
                    }
                }
            }
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyLab[i][j] == 0) sum++; // 안전공간이 있다면 sum 카운트
            }
        }

        result = Math.max(result, sum); // 안전공간 최대값 갱신
    }
}
