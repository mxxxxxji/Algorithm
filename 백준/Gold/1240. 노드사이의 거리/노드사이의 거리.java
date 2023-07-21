import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Node> list[];
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        list = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));

        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(bfs(a, b)).append('\n');
        }
        System.out.print(sb);
    }
    public static int bfs(int start, int end){
        visited = new boolean[N+1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visited[start] = true;
        int dist = 0;
        while(!q.isEmpty()){
            Node p = q.poll();
            if(p.next == end) {
                dist = p.value;
                break;
            }
            for(int i=0; i<list[p.next].size(); i++){
                int next = list[p.next].get(i).next;
                int len = list[p.next].get(i).value;
                if(visited[next]) continue;
                visited[next] = true;
                q.add(new Node(next, p.value + len));
            }
        }
        return dist;
    }

}
class Node{
    int next;
    int value;
    Node(int next, int value){
        this.next = next;
        this.value = value;
    }
}