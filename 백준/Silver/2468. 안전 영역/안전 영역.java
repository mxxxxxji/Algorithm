import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] check;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int max = 1;
    static int cnt = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max<map[i][j]) max = map[i][j];
            }
        }
        // 높이가 i일 때
        for(int i=1; i<=max; i++){
            visited = new boolean[N][N];
            check = new boolean[N][N];
            // 물에 잠기는 부분 구하기
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(map[j][k]<=i) check[j][k] = true;
                }
            }
            // 안정영역 구하기
            int count = 0;
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(visited[j][k]) continue;
                    if(check[j][k]) continue;
                    bfs(j, k);
                    count++;
                }
            }
            cnt = Math.max(count, cnt);
        }
        System.out.println(cnt);
    }
    static void bfs(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        visited[a][b] = true;
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0]; int c = p[1];
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr<0 || nc<0 || nr>N-1 || nc>N-1) continue;
                if(visited[nr][nc]) continue;
                if(check[nr][nc]) continue;
                visited[nr][nc]=true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}