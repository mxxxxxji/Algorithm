import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int start, end;
    static int[] dist;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        dijkstra();
        System.out.println(dist[end]);
    }
    private static void dijkstra(){
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return o1.cost-o2.cost;
            }
        });
        pq.add(new Node(start, 0));
        dist[start] =0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.city==end) break;
            if(node.cost > dist[node.city])continue;
            for(int i=0; i<graph.get(node.city).size(); i++){
                Node next =  graph.get(node.city).get(i);
                if(dist[next.city]>next.cost+node.cost){
                    dist[next.city]=next.cost+node.cost;
                    pq.add(new Node(next.city, dist[next.city]));
                }
            }
        }
    }
    static class Node{
        int city, cost;
        public Node(int city, int cost){
            this.city = city;
            this.cost = cost;
        }
    }
}