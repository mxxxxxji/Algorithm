import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int cnt;//단지갯수
    static int mark;//단지번호
    static ArrayList<Integer> res = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        mark=1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1){
                    bfs(i,j);

                }
            }
        }
        System.out.println(mark-1);
        res.sort(null);
        for(int x:res){
            sb.append(x+"\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        cnt=1;
        mark++;
        q.add(new int[]{r, c});
        map[r][c] = mark;
        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i=0; i<4; i++){
                int nr = p[0] + dir[i][0];
                int nc = p[1] + dir[i][1];

                if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
                if(map[nr][nc]!=1) continue;
                map[nr][nc] = mark;
                cnt++;
                q.add(new int[]{nr, nc});

            }
        }
        res.add(cnt);
    }
}