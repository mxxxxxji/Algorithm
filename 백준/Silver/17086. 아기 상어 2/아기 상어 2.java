import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> q;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) q.add(new int[]{i, j});
            }
        }
        bfs();

    }
    public static void bfs(){
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0]; int c = p[1];
            for(int i=0; i<8; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr<0 || nc<0 || nr>N-1 || nc>M-1) continue;
                //if(map[nr][nc]==1) continue;
                //if(map[nr][nc]>map[r][c] + 1)continue;
                if(map[nr][nc]==0){
                    map[nr][nc] = map[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }

            }
        }
//        for(int i=0; i<N; i++){
//            for(int j=0; j<M; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]>max) max = map[i][j];
            }
        }
        System.out.println(max-1);
    }
}