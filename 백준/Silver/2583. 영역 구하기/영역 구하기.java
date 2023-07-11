import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static StringBuilder sb;
    static ArrayList<Integer> list;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        list = new ArrayList<>();

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            for(int j=N-y2; j<N-y1; j++){
                for(int k=x1; k<x2; k++){
                    map[j][k] = 1;
                }
            }

        }
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && map[i][j]==0) {
                    count++;
                    cnt=0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
    }

    public static void dfs(int r, int c){
        visited[r][c] = true;
        cnt++;
        for(int i=0; i<4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if(nr<0 || nc<0 || nr>N-1 || nc>M-1) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc]==1) continue;
            dfs(nr, nc);

        }
    }
}