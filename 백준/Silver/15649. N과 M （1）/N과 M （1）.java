
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 53
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        combination(n, m, new boolean[n+1], new int[m], 0);
        System.out.println(sb);

    }
    static void combination(int n, int m, boolean[] visited, int[] arr, int depth){
        if(depth == m){
            for(int num : arr){
                sb.append(num).append(' ');
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++){
            if(visited[i]) continue;

            arr[depth] = i;
            visited[i] = true;
            combination(n, m, visited, arr, depth+1);
            visited[i] = false;
        }
    }

}
