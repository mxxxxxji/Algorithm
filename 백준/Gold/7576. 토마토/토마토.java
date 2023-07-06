import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static Queue<int[]> q;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    q.add(new int[]{i, j});
                }
            }
        }

        bfs();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0) {
                    answer = -1;
                    break;
                }else{
                    answer = Math.max(answer, map[i][j]);
                }

            }
            if(answer==-1) break;
        }
        if(answer!=-1) answer-=1;
        System.out.println(answer);
    }
    private static void bfs(){
        while(!q.isEmpty()){
            int[] p = q.poll();
            visited[p[0]][p[1]] = true;
            for(int i=0; i<4; i++){
                int nr = p[0] + dir[i][0];
                int nc = p[1] + dir[i][1];

                if(nr<0 || nc<0 || nr>N-1 || nc>M-1) continue;
                if(!visited[nr][nc] && map[nr][nc]==0) {
                    map[nr][nc] = map[p[0]][p[1]]+1;
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

}