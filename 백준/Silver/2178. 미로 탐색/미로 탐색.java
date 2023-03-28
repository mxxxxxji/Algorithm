import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        bfs(0, 0);
        System.out.println(map[N-1][M-1]);
    }
    public static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[]{r, c});
        while(!q.isEmpty()){
            int cur[] = q.poll();
            for(int i=0; i<4; i++){
                int nr = cur[0] + dir[i][0];
                int nc = cur[1] + dir[i][1];

                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if(visited[nr][nc] || map[nr][nc] == 0) continue;


                q.add(new int[]{nr, nc});
                map[nr][nc] = map[cur[0]][cur[1]] + 1;
                visited[nr][nc] = true;
            }
        }
    }
}