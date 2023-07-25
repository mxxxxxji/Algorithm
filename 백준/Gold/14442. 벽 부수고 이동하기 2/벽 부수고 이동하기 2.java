import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map;
    static int[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int res;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new int[N+1][M+1];
        for(int i=0; i<N+1; i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        for(int i=1; i<N+1; i++){
            String[] s = br.readLine().split("");
            for(int j=1; j<M+1; j++){
                map[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        res = -1;
        bfs();

        System.out.println(res);

    }
    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1, 0, 1});
        visited[1][1] = 0;
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0];
            int c = p[1];
            int b = p[2];
            int dist = p[3];
            if(r == N && c == M) {
                res=dist; break;
            }
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr<1 || nc<1 || nr>N || nc>M) continue;
                if(visited[nr][nc]<=b) continue;
                if(map[nr][nc]==1) { // 벽일때
                    if(b+1<visited[nr][nc] && b<K) {
                        visited[nr][nc] = b+1;
                        q.add(new int[]{nr, nc, b+1, dist+1});
                    }
                }else{
                    visited[nr][nc] = b;
                    q.add(new int[]{nr, nc, b, dist+1});
                }
            }
        }
    }
}