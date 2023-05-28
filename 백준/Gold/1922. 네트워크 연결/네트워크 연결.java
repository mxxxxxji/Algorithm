import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    static PriorityQueue<Node> pq;
    static int result;
    // 부모를 합친다. 합집합 형성
    public static void union(int a, int b){
        int a_parent = find(a);
        int b_parent = find(b);

        if(a_parent < b_parent)
            parent[b_parent] = a_parent;
        else
            parent[a_parent] = b_parent;
    }

    // 부모를 찾는다. 사이클 형성하는지 판단
    public static int find(int i){
        if(parent[i] == i) return i;
        return find(parent[i]);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        pq = new PriorityQueue<>();
        result = 0;
        for(int i=1; i<N; i++){
            parent[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start  = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Node(start, end, cost));
        }
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(find(node.start) != find(node.end)){
                result += node.cost;
                union(node.start, node.end);
            }
        }
        System.out.println(result);
    }
}
class Node implements Comparable<Node>{
    int start;
    int end;
    int cost;
    public Node(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }


}