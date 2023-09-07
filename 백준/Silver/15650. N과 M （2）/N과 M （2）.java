import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N+1];
        dfs(1,0);
        System.out.print(sb);
    }
    static void dfs(int start, int depth){
        if(depth==M){
            for(int i=0; i<arr.length; i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=start; i<N+1; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            dfs(i+1,depth+1);
            visited[i] = false;

        }
    }
}