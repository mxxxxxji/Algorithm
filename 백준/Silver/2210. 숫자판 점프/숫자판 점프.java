import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int[][] map;
    static String s;
    static HashSet<String> set;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        set = new HashSet<>();
        map = new int[5][5];
        visited = new boolean[5][5];
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){

                dfs(i, j, 0, ""+map[i][j]);

            }
        }
        System.out.println(set.size());
    }
    public static void dfs(int r, int c, int cnt, String s){

        if(cnt==5){
            set.add(s);
            return;
        }

        for(int i=0; i<4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if(nr<0 || nc<0 || nr>=5 || nc>=5) continue;

            dfs(nr, nc, cnt+1, s + map[nr][nc]);

        }
    }
}