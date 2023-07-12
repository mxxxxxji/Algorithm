import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static String[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int sheep, wolf;
    static int resS, resW;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<C; j++){
                map[i][j] = s[j];
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && !"#".equals(map[i][j])){
                    wolf=0 ; sheep=0;
                    dfs(i, j);
                    if(sheep>wolf) resS += sheep;
                    else resW += wolf;
                }
            }
        }
        System.out.println(resS +" "+ resW);
    }
    public static void dfs(int r, int c){
        visited[r][c] = true;
        if("o".equals(map[r][c])) sheep++;
        if("v".equals(map[r][c])) wolf++;
        for(int i=0; i<4; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if(nr<0 || nc<0 || nr>R-1 || nc>C-1) continue;
            if("#".equals(map[nr][nc])) continue;
            if(visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }
}