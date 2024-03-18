import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static char[][] after;
    static int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    static int minR=10, minC=10, maxR=0, maxC=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        after = new char[R][C];
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = s.charAt(j);
                after[i][j] = '.';
                if(map[i][j]=='X') list.add(new int[]{i, j});
            }
        }
        for(int i=0; i<list.size(); i++){
            int cnt = 0;
            int r = list.get(i)[0];
            int c = list.get(i)[1];
            for(int j=0; j<4; j++){
                int nr = r + dir[j][0];
                int nc = c + dir[j][1];
                if(nr<0 || nc<0 || nr>R-1 || nc>C-1 || map[nr][nc] == '.') cnt++;
            }
            if(cnt<3){
                after[r][c] = 'X';
                minR = Math.min(minR, r);
                minC = Math.min(minC, c);
                maxR = Math.max(maxR, r);
                maxC = Math.max(maxC, c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=minR; i<=maxR; i++){
            for(int j=minC; j<=maxC; j++){
                sb.append(after[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}