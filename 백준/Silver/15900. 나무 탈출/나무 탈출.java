import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> tree;
    static int s;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            tree.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        s=0;
        visited = new boolean[N + 1];
        dfs(1, 0, visited);
        if(s%2==0)System.out.println("No");
        else System.out.println("Yes");
    }
    static void dfs(int node, int depth, boolean[] visited){
        visited[node] = true;

        for (int next : tree.get(node)) {

            if(!visited[next]){
                dfs(next, depth+1, visited);}
        }

        if(node != 1 && tree.get(node).size() == 1){
            s+=depth;
        }
    }
}