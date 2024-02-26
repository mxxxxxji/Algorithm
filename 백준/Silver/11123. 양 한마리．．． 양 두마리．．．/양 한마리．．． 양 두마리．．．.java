import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int H,W;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            visited = new boolean[H][W];
            for(int i=0; i<H; i++){
                String s = br.readLine();
                for(int j=0; j<W; j++){
                    map[i][j] = s.charAt(j);
                }
            }
            int count = 0;
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(visited[i][j] || map[i][j]=='.') continue;
                    bfs(i, j);
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
    private static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0]; int c = p[1];
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr<0 || nc<0 || nr>H-1 || nc> W-1) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc]=='.') continue;
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}