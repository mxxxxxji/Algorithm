import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static String s;
    static int r;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(r=1; r<N; r++){
            dfs(1, 0); // 스타트팀 기준
        }
        System.out.println(min);
    }
    static void dfs(int start, int depth){
        if(depth==r){
            min = Math.min(diff(), min);
            return;
        }
        for(int i=start; i<N+1; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }
    static int diff(){
        int start = 0;
        int link = 0;
        for(int i=1; i<N; i++){
            for(int j=i+1; j<N+1; j++){
                if(visited[i] && visited[j]){
                    start += (arr[i][j] + arr[j][i]);
                }
                else if(!visited[i] && !visited[j]){
                    link += (arr[i][j] + arr[j][i]);
                }
            }
        }
        return Math.abs(start-link);
    }
}