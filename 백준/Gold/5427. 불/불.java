import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int W, H;
    static char[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<Pos> firePos;
    static Pos startPos;
    static int result;
    static StringBuilder sb = new StringBuilder();
    static int[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());


        while(T-->0){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            firePos = new ArrayList<>();

            for(int i=0; i<H; i++){
                String s = br.readLine();
                for(int j=0; j<W; j++){
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == '@') startPos = new Pos(i, j,0);
                    if(map[i][j] == '*') firePos.add(new Pos(i, j,0));
                }
            }
            result = 0;
            visited = new int[H][W];
            bfs();

            if(result == 0) sb.append("IMPOSSIBLE").append('\n');
            else sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
    private static void bfs(){

        Queue<Pos> personQ = new LinkedList<>();
        personQ.add(startPos);
        visited[startPos.r][startPos.c] = 1;

        Queue<Pos> fireQ = new LinkedList<>();
        for(int i=0; i<firePos.size(); i++){
            fireQ.add(firePos.get(i));
        }

        while(!personQ.isEmpty()){

            int size  = fireQ.size();
            for(int i=0; i<size; i++){
                Pos fireP =  fireQ.poll();
                for(int j=0; j<4; j++){
                    int nr = fireP.r + dir[j][0];
                    int nc = fireP.c + dir[j][1];
                    if(nr<0 || nc<0 || nr>H-1 || nc>W-1) continue;
                    if(map[nr][nc] == '.' || map[nr][nc]=='@') {
                        map[nr][nc] = '*';
                        fireQ.add(new Pos(nr, nc,0));
                    }
                }
            }
            size = personQ.size();
            for(int j=0; j<size; j++){
                Pos personP = personQ.poll();
              
                for(int i=0; i<4; i++){
                    int nr = personP.r + dir[i][0];
                    int nc = personP.c + dir[i][1];
                    if(nr<0 || nc<0 || nr>H-1 || nc>W-1){
                        result = personP.time+1;
                        return;
                    }
                    //sb.append(" ---").append(nr).append("*").append(nc).append('\n');
                    if(map[nr][nc] == '.'){
                        map[nr][nc] = '@';
                        //visited[nr][nc] = visited[personP.r][personP.c] + 1;
                        personQ.add(new Pos(nr, nc, personP.time+1));
                    }

                }
            }

        }

    }
    static class Pos{
        int r, c, time;
        public Pos(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}