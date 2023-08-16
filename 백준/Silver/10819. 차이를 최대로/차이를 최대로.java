import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] res;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        res = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
    }
    private static void dfs(int cnt){
        if(cnt==N){
            int sum=0;
            for(int i=0; i<N-1; i++){
                sum += Math.abs(res[i]-res[i+1]);

            }
            max = Math.max(sum, max);
            return;
        }
        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            res[cnt] = arr[i];
            dfs(cnt+1);
            visited[i] = false;
        }
    }
}