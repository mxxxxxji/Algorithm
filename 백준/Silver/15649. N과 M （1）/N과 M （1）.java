
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        visited = new boolean[n+1];

        combination(new int[m], 0);
        System.out.println(sb);
    }
    static void combination(int[]arr, int depth){
        if(depth == m){
            for(int num : arr){
                sb.append(num);
                sb.append(' ');
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                arr[depth] = i;
                visited[i] = true;
                combination(arr, depth+1);
                visited[i] = false;

            }
        }
    }
}
