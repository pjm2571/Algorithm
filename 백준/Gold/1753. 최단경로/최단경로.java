import java.util.*;
import java.lang.*;
import java.io.*;

class Edge implements Comparable<Edge>{
    int endVertex;
    int weight;

    public Edge(int endVertex, int weight){
        this.endVertex = endVertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other){
        return this.weight - other.weight;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        int startVertex = Integer.parseInt(br.readLine());

        List<List<Edge>> list = new ArrayList<>();
        for(int i=0; i<=v; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<e; i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            list.get(start).add(new Edge(end, weight));
        }

        int[] distances = new int[v+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        DFS(startVertex, list, distances);

        for(int i=1; i<=v; i++){
            System.out.println(distances[i] == Integer.MAX_VALUE ? "INF" : distances[i]);
        }
        
        br.close();
    }

    private static void DFS(int startVertex, List<List<Edge>> list, int[] distances){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(startVertex, 0));

        while(!pq.isEmpty()){
            Edge current = pq.poll(); // 항상 최소 weight만 가져와진다.
            int nowVertex = current.endVertex;
            int nowWeight = current.weight;

            for(Edge edge : list.get(nowVertex)){
                if(distances[edge.endVertex] > nowWeight + edge.weight){
                    distances[edge.endVertex] = nowWeight + edge.weight;
                    pq.offer(new Edge(edge.endVertex, nowWeight + edge.weight));
                }
            }
        }
    }
}