import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for(int i=0; i<N; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(s[j]);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        answer = Integer.MAX_VALUE;
        bfs(0, 0);
        if(answer==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.print(answer);

    }
    private static void bfs(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b, 1, 0});
        visited[a][b] = 0; // 공사횟수
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0];
            int c = p[1];
            int dist = p[2];
            int block = p[3];
            if(p[0]==N-1 && p[1]==M-1){
                answer =  dist; break;
            }
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                //System.out.println(flag);
                if(nr<0 || nc<0 || nr>N-1 || nc>M-1) continue;

                if(visited[nr][nc]<=block) continue;

                // 벽이 아닐때
                if(map[nr][nc] == 0){
                    visited[nr][nc] = block;
                    q.add(new int[]{nr, nc, dist+1, block});
                }else{ // 벽 일때
                    if(block == 0){
                        visited[nr][nc] = block + 1;
                        q.add(new int[]{nr, nc, dist+1, block+1});
                    }
                }
            }
        }
    }
}