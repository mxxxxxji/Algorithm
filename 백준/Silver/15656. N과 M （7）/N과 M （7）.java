import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] number;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        number = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);
        dfs(0);
        System.out.print(sb);
    }
    static void dfs(int depth){
        if(depth==M){
            for(int num : arr){
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=0; i<N; i++){
            arr[depth] = number[i];
            dfs(depth+1);
        }
    }
}