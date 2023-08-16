import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static boolean[] visited;
    static int[] res;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        res = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++){
            dfs(0, 0, i);
        }
        System.out.println(cnt);
    }
    public static void dfs(int start, int depth, int R){
        if(depth == R){
            int sum=0;
            for(int i=0; i<N; i++){
                if(visited[i]){
                    sum += res[i];
                }
                //System.out.print(res[i]+" ");
            }
            if(sum==S) cnt++;
           // System.out.println();
        }
        for(int i=start; i<N; i++){
            if(visited[i]) continue;
            res[i] = arr[i];
            visited[i] = true;
            dfs(i+1, depth+1, R);
            visited[i] = false;
        }
    }
}