
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        permutation(1, n, m, new int[m], new boolean[n+1], 0);
        System.out.println(sb);
    }
    static void permutation(int start,  int n, int m, int[] arr, boolean[] visited, int depth){
        if(depth == m){
            for(int num : arr){
                sb.append(num).append(' ');
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i<=n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            permutation(i+1, n, m, arr, visited, depth+1);
            visited[i] = false;

        }

    }
}
