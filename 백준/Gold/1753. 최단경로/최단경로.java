import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int V, E, K;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i=0; i<V+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
        }
        visited = new boolean[V+1];
        dist = new int[V+1];
        for(int i=0; i<V+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        bfs();

        // 출력 부분
        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.println(sb);
    }
    static void bfs(){
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost-o2.cost;
            }
        });
        q.add(new Node(K, 0));

        dist[K] = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();

            if(dist[cur.idx]<cur.cost) continue;
            for(int i=0; i<graph.get(cur.idx).size(); i++){
                Node next = graph.get(cur.idx).get(i);
                if(dist[next.idx] > next.cost + cur.cost){
                    dist[next.idx] = next.cost + cur.cost;
                    q.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }
    static class Node {
        int idx, cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
}