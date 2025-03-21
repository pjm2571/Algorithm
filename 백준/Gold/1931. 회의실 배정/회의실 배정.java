import java.util.*;
import java.lang.*;
import java.io.*;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;
    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting other){
        if(this.end == other.end){
            return this.start - other.start;
        }
        return this.end - other.end;
    }
}

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start= Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        int count = 0;
        
        int start = 0;
        
        for(int i=0; i<n; i++){
            Meeting current = meetings.get(i);
            if(current.start >= start){
                count++;
                start = current.end;
            }
        }

        System.out.println(count);

        br.close();
    }
}