import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int H;
    static int[][][] map;
    // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
    static int[][] dir = {{0,0,1}, {0,0,-1}, {-1,0,0}, {1,0,0}, {0,1,0}, {0,-1,0}};
    static int result = Integer.MIN_VALUE;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[M+1][N+1][H+1];
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    map[k][j][i] = Integer.parseInt(st.nextToken());
                    if (map[k][j][i] == 1) q.add(new int[] {k, j, i});
                }
            }
        }

        System.out.println(bfs());

    }

    static int bfs(){
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0];
            int c = p[1];
            int h = p[2];

            for(int i=0; i<6; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                int nh = h + dir[i][2];

                if(nr<0 || nc<0 || nh<0 || nr>=M || nc>=N || nh>=H) continue;

                if(map[nr][nc][nh]==0){
                    q.add(new int[]{nr, nc, nh});
                    map[nr][nc][nh] = map[r][c][h] + 1;
                }
            }
        }
        // 1:익은, 0:안익은, -1:빈칸
        for(int i=0; i<H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(map[k][j][i] == 0) return -1;
                    if(map[k][j][i] > result){
                        result = map[k][j][i];
                    }
                }
            }
        }
        // 원래부터 모두 익어있는 경우
        if(result == 1) return 0;
        else return result-1;

    }


}