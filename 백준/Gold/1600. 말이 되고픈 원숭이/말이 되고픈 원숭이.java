import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] dirMonkey = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int[][] dirHorse = {{-2,-1}, {-2,1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}, {2,-1}, {2,1}};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        if(answer == Integer.MAX_VALUE) sb.append("-1").append('\n');
        else sb.append(answer).append('\n');

        System.out.println(sb);
    }
    private static void bfs(){
        StringBuilder sb = new StringBuilder();
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 0, 0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
                Pos p = q.poll();
                int r = p.r; int c = p.c; int cnt = p.cnt;
                if(r==H-1 && c==W-1) {
                    answer = cnt;
                    return;
                }
                for(int j=0; j<4; j++){
                    int nr = r + dirMonkey[j][0];
                    int nc = c + dirMonkey[j][1];
                    if(nr<0 || nc<0 || nr>H-1 || nc>W-1) continue;
                    if(map[nr][nc]==1) continue;
                    if(visited[nr][nc][p.k]) continue; // 지나간 경우 (0:원숭이걸음으로 지나갔거나, 그 외 숫자: 현재 k번만큼 말걸음으로 지나감)
                    visited[nr][nc][p.k] = true;
                    q.add(new Pos(nr, nc, cnt+1, p.k));
                }
                if(p.k<K){
                    for(int j=0; j<8; j++){
                        int nr = r + dirHorse[j][0];
                        int nc = c + dirHorse[j][1];
                        if(nr<0 || nc<0 || nr>H-1 || nc>W-1) continue;
                        if(visited[nr][nc][p.k+1]) continue;
                        if(map[nr][nc]==1) continue;
                        visited[nr][nc][p.k+1] = true;
                        q.add(new Pos(nr, nc, cnt+1, p.k+1));


                    }
                }
        }
    }
    static class Pos{
        int r, c, cnt, k;
        public Pos(int r, int c, int cnt, int k){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.k = k;
        }
    }
}