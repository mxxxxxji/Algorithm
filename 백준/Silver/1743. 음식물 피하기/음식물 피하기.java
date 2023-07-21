import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }
        int max = 0;
        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                if(visited[i][j]) continue;
                if(map[i][j]==0) continue;
                max = Math.max(max, bfs(i, j));
            }
        }
        System.out.println(max);
    }
    public static int bfs(int r, int c){
        int size = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;
        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i=0; i<4; i++){
                int nr = p[0] + dir[i][0];
                int nc = p[1] + dir[i][1];

                if(nr<1 || nc<1 || nr>N || nc>M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc]==0) continue;
                visited[nr][nc] = true;
                size++;
                q.add(new int[]{nr, nc});
            }
        }
        return size;
    }
}