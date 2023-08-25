import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
    static int res;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dist = new int[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j);
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]=='W')continue;
                visited = new boolean[N][M];
                bfs(i, j);

            }
        }

        System.out.println(res);
    }
    static void bfs(int start_r, int start_c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_r, start_c});
        visited[start_r][start_c] = true;
        dist[start_r][start_c] = 0;

        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0];
            int c = p[1];
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr<0||nc<0||nr>N-1||nc>M-1) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 'W') continue;
                visited[nr][nc] = true;
                dist[nr][nc] = dist[r][c] + 1;
                q.add(new int[]{nr, nc});
                res = Math.max(res, dist[nr][nc]);
            }
        }

    }
}