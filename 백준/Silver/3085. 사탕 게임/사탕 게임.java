import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = s.charAt(j);
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                // 가로로 인접한 두 색깔 교환
                char temp = map[i][j];
                map[i][j] = map[i][j+1];
                map[i][j+1] = temp;

                find();

                // 교환한 문자 복구
                map[i][j+1] = map[i][j];
                map[i][j] = temp;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                // 세로로 인접한 두 색깔 교환
                char temp = map[j][i];
                map[j][i] = map[j+1][i];
                map[j+1][i] = temp;

                find();

                // 교환한 문자 복구
                map[j+1][i] = map[j][i];
                map[j][i] = temp;
            }
        }
        System.out.println(max);
    }
    private static int find(){
        for(int i=0; i<N; i++){
            int cnt = 1;
            for(int j=0; j<N-1; j++){
                if(map[i][j]==map[i][j+1]) cnt++;
                else cnt=1;
                max = Math.max(cnt, max);
            }
        }

        for(int i=0; i<N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if(map[j][i] == map[j+1][i]) cnt++;
                else cnt=1;
                max = Math.max(cnt, max);
            }
        }
        return 0;
    }
//    private static void dfs(int r, int c, int cnt, char color, int change){
//        System.out.println(r+","+c+" cnt: "+cnt+" color: "+color+" change: "+change);
//        max = Math.max(max, cnt);
//        for(int i=0; i<4; i++){
//            int nr = r + dir[i][0];
//            int nc = c + dir[i][1];
//
//            if(nr<0 || nc<0 || nr>N-1 || nc>N-1) continue;
//            if(visited[nr][nc]) continue;
//            if(map[nr][nc] != color){
//                System.out.println("같은색아님");
//                if(change==0){ //아직 블록 변경 안했다면
//                    System.out.println("변경");
//                    for(int j=0; j<4; j++){
//                        int sr = nr + dir[j][0];
//                        int sc = nc + dir[j][1];
//                        if(sr<0 || sc<0 || sr>N-1 || sc>N-1) continue;
//                        if(map[sr][sc]!=color) continue;
//                        //주변에 바꿀 색이 있다면
//                        map[nr][nc] = map[sr][sc];
//                        map[sr][sc] = color;
//                        visited[nr][nc] = true;
//                        dfs(nr, nc, cnt+1, color, 1);
//                      //  visited[nr][nc] = false;
//                        map[nr][nc] = color;
//                        map[sr][sc] = map[nr][nc];
//                    }
//                }else{
//                    return;
//                }
//            }else{
//                System.out.println("같은색");
//                visited[nr][nc] = true;
//                dfs(nr, nc, cnt+1, color, 0);
//              //  visited[nr][nc] = false;
//            }
//        }
//    }
}