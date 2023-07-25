import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int r1, r2, c1, c2;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
    static int res;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());


        bfs(r1, c1);

        if(map[r2][c2] == 0)  System.out.println(-1);
        else System.out.println(map[r2][c2]);
    }
//    public static void dfs(int r, int c, int cnt){
//        if(r==r2 && c==c2){
//            res = Math.min(res, cnt);
//        }
//        for(int i=0; i<6; i++){
//            int nr = r + dir[i][0];
//            int nc = c + dir[i][1];
//
//            if(nr<0 || nc<0 || nr>N-1 || nc>N-1) continue;
//            if(visited[nr][nc]) continue;
//            visited[nr][nc] = true;
//            dfs(nr, nc, cnt+1);
//            visited[nr][nc] = false;
//        }
//    }
    public static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[]{r, c});
        while(!q.isEmpty()){
            int[] p = q.poll();
            if(p[0]==r2 && p[1]==c2) return;
            for(int i=0; i<6; i++) {
                int nr = p[0] + dir[i][0];
                int nc = p[1] + dir[i][1];

                if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1) continue;
                if (visited[nr][nc]) continue;
                visited[nr][nc] = true;
                map[nr][nc] = map[p[0]][p[1]] + 1;
                res++;
                q.add(new int[]{nr, nc});
            }
        }
    }
}