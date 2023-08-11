import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int N;
    static int[] number;
    static boolean[] visited;
    static int[] answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            number = new int[N];

            for(int i=0; i<N; i++){
                number[i] = Integer.parseInt(st.nextToken());
            }
            answer = new int[N+1];
            visited = new boolean[N+1];
            dfs(0, 0);
            System.out.println(sb);

        }

    }
    private static void dfs(int depth, int start){
        if(depth == 6){
            for(int i=0; i<N; i++){
                if(visited[i]){
                    sb.append(number[i]).append(' ');
                }

            }
            sb.append('\n');
        }
        for(int i=start; i<N; i++){
            visited[i]= true;
            dfs(depth+1,i+1);
            visited[i] = false;
        }



    }
}