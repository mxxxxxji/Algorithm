import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1,0 }, {1,0}, {0,-1}, {0,1}};
    static int min=64;
    public static void main(String[] arags)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<N-7; i++){
            for(int j=0; j<M-7; j++){
                find(i, j);
            }
        }
       System.out.println(min);
    }
    public static void find(int r, int c){
        char color = map[r][c];
        int count = 0;
        for(int i=r; i<r+8; i++){
            for(int j=c; j<c+8; j++){
                if(map[i][j]!=color){
                    count++;

                }
                if(color=='W') color='B';
                else color = 'W';
            }
            if(color=='W') color='B';
            else color = 'W';
        }

        count = Math.min(count, 64-count);
        min = Math.min(min, count);
    }
}