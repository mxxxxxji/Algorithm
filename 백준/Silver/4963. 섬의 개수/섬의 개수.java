import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {1,1}, {1,-1}, {-1,1}};
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            cnt = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(visited[i][j]) continue;
                    if(map[i][j]==0) continue;
                    visited[i][j] = true;
                    dfs(i, j);
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
    public static void dfs(int r, int c){
        for(int i=0; i<8; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if(nr<0 || nc<0 || nr>h-1 || nc>w-1) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc]==0) continue;
            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }
}