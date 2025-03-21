import java.util.*;
import java.lang.*;
import java.io.*;

class Tower{
    int index;
    int height;

    public Tower(int index, int height){
        this.index = index;
        this.height = height;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Tower[] towers = new Tower[n];
        for(int i=0; i<n; i++){
            towers[i] = new Tower(i+1, Integer.parseInt(st.nextToken()));
        }

        int[] result = solution(n, towers);

        for(int val : result) System.out.print(val + " ");

        br.close();
    }

    private static int[] solution(int n, Tower[] towers){
        int[] result = new int[n];
        
        Stack<Tower> stack = new Stack<>();

        for(int i=0; i < n; i++){
            Tower current = towers[i];
            if(stack.isEmpty()){
                stack.push(current);
                result[i] = 0;
            }    
            else{
                while(true){
                    if(stack.isEmpty()){
                        result[i] = 0;
                        stack.push(current);
                        break;
                    }
                    
                    Tower previous = stack.peek();
                    
                    if(previous.height > current.height){
                        result[i] = previous.index;
                        stack.push(current);
                        break;
                    } else{
                        stack.pop();
                    }
                }
            }
        }

        return result;
    }
}