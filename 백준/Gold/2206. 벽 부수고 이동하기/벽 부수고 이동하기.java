import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int[][] visited; // 공사횟수
    static int result=-1;
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
        bfs();
        System.out.println(result);
    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 1});
        visited[0][0]=0;
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0]; int c = p[1]; int block = p[2]; int cnt = p[3];
            if(r==N-1&& c==M-1) {
                result = cnt;
                break;
            }
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr<0 || nc<0 || nr>N-1 || nc>M-1) continue;
                // 벽을 부수고 지나갔을 경우 visit=1, 벽을 부수지 않고 오늘 녀석 block=0
                if(visited[nr][nc]<=block) continue;
             //   System.out.println(r+", "+c+", "+block+", "+cnt);
             //   System.out.println(nr+", "+nc);
                if(map[nr][nc]==1){
                    if(block==0){
                        visited[nr][nc] = block+1;
                        q.add(new int[]{nr, nc, block+1, cnt+1});
                    }
                }else {
                    visited[nr][nc] = block;
                    q.add(new int[]{nr, nc, block, cnt+1});
                }
            }
        }
    }
}