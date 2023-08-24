import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N + 1][M + 1];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0);
        System.out.println(max);
    }
    public static void dfs(int r, int c, int depth, int value){

        if(depth==K){
            max = Math.max(max, value);
            return;
        }
        for(int i=r; i<N; i++){
            for(int j=c; j<M; j++){
                if (!visited[i][j]) {
                    if (check(i, j)) {
                        visited[i][j] = true;
                        dfs(r, c, depth+1, value+map[i][j]);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }
    public static boolean check(int x, int y) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < M) {
                if (visited[next_x][next_y]) {
                    flag = false;
                }
            }
        }
        return flag;
    }
}