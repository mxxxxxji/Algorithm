import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[][] map;
    static boolean[][] visited;
    static int cnt;
    static int sumW, sumB;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[M][N];


        for(int i=0; i<M; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<N; j++){
                map[i][j] = s[j];
            }
        }
        visited = new boolean[M][N];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    cnt=1;
                    dfs(i, j, map[i][j]);
                    //System.out.println(cnt+",,,");
                    if("W".equals(map[i][j])){
                        sumW += cnt*cnt;
                    }else{
                        sumB += cnt*cnt;
                    }

                }
            }
        }
        System.out.println(sumW+" "+sumB);

    }
    public static void dfs(int r, int c, String s){
        visited[r][c] = true;
        for(int i=0; i<4; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if(nr<0 || nc<0 || nr>M-1 || nc>N-1)continue;
            if(visited[nr][nc])continue;
            if(!map[nr][nc].equals(s))continue;
            cnt++;
            dfs(nr, nc, s);
        }
    }
}