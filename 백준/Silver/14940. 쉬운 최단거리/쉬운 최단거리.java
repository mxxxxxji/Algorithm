import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] res;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int end_r, end_c;
    static int len;
    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        res = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    end_r = i;
                    end_c = j;
                    res[i][j] = 0;
                }else if(map[i][j]==1) res[i][j]=-1;
            }
        }

        bfs(end_r, end_c);
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(res[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void bfs(int a, int b){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        visited[a][b] = true;
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0]; int c = p[1];

            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr<0 || nc<0|| nr>N-1 || nc>M-1) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc]==0) continue;
                visited[nr][nc] = true;
                res[nr][nc] = res[r][c] + 1;
                q.add(new int[]{nr, nc});
            }
        }

    }
}