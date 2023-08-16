import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] w;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        w = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            //System.out.println("**"+i);
            dfs(i, 0, 0, i);
        }
        System.out.println(min);
    }
    public static void dfs(int v, int depth, int cost, int start){
        if(depth==N && v==start){
            min = Math.min(min, cost);
            return;
        }
        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            if(w[v][i]==0) continue;
            visited[i] = true;
           // System.out.println(v+"->"+i+" :"+w[v][i]+"cost : "+cost);
            dfs(i, depth+1, cost+w[v][i], start);
            visited[i] = false;

        }
    }
}