import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, E;
    static int V1, V2;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static int res1, res2;
    static int INF = 20000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        dist = new int[N+1];

        res1 += dijkstra(1, V1);
        res1 += dijkstra(V1, V2);
        res1 += dijkstra(V2, N);
        //System.out.println(res1);
        res2 += dijkstra(1, V2);
        res2 += dijkstra(V2, V1);
        res2 += dijkstra(V1, N);
        //System.out.println(res2);
        if(res1>=INF && res2>=INF) System.out.println(-1);
        else System.out.println(Math.min(res1, res2));
    }
    static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost-o2.cost;
            }
        });
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            //if(cur.idx == end) break;
            //if(dist[cur.idx]<cur.cost) continue;
            for(int i=0; i<graph.get(cur.idx).size(); i++){
                Node next = graph.get(cur.idx).get(i);
                if(dist[next.idx]> next.cost+cur.cost){
                    dist[next.idx] =  next.cost+cur.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        return dist[end];
    }
    static class Node{
        int idx, cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
}