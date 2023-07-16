import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i=0; i<N; i++){
            if(map[0][i]==0 && !visited[0][i]){
                visited[0][i]=true;
                dfs(0, i);
            }
            if(flag==1) break;
        }
        if(flag==1)System.out.println("YES");
        else System.out.println("NO");
    }
    public static void dfs(int r, int c){
        if(r==M-1 && map[r][c]==0){
            flag = 1;
        }
        for(int i=0; i<4; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (nr<0 || nc<0 || nr>M-1 || nc>N-1) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc]==1) continue;
            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }
}