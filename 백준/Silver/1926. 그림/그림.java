import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m; // 세로, 가로
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int answer;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && map[i][j]==1){
                    bfs(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
        System.out.println(max);
    }

    private static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;
        int size = 1;
        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i=0; i<4; i++){
                int nr = p[0] + dir[i][0];
                int nc = p[1] + dir[i][1];

                if(nr<0 || nc<0 || nr>n-1 || nc>m-1) continue;
                if(!visited[nr][nc] && map[nr][nc]==1){
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    size+=1;
                }
            }
        }
        max = Math.max(size, max);
    }
}