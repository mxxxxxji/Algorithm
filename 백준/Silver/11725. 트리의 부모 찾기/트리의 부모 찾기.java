import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        parent = new int[N+1];

        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        for(int i=2; i<N+1; i++){
            System.out.println(parent[i]);
        }
    }
    public static void dfs(int x){
        visited[x] = true;
        for(int i=0; i<list[x].size(); i++){
            int next = list[x].get(i);
            if(!visited[next]){
                parent[next] = x;
                dfs(next);
            }
        }
    }
}