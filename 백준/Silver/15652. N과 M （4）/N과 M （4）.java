import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N+1];
        dfs(0, 0);
        System.out.print(sb);
    }
    static void dfs(int start, int depth){
        if(depth == M){
            for(int i=0; i<arr.length; i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=start; i<N; i++){
            arr[depth] = i+1;
            dfs(i, depth+1);
        }
    }
}