import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Node>[] list;
    static int max = 0;
    static boolean[] visited;
    static int max_idx=1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }
        visited[1] = true;
        dfs(1,0);
        visited = new boolean[N+1];
        visited[max_idx] = true;
        dfs(max_idx, 0);
        System.out.println(max);
    }
    static void dfs(int n, int value){
        //System.out.println("depth: "+ depth);
        if(max<value) {
            max = value;
            max_idx = n;
        }
        for(int i=0; i<list[n].size(); i++){
            int next = list[n].get(i).e;
            if(visited[next]) continue;
            visited[next] = true;
            dfs(next, value+list[n].get(i).w);
        }
    }
    static class Node{
        int e; int w;
        public Node(int e, int w){
            this.e = e;
            this.w = w;
        }
    }

}