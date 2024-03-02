import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static Queue<Pos> hedgehogQ;
    static Queue<Pos> waterQ;
    static boolean[][] visited;
    static StringBuilder sb;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        hedgehogQ = new LinkedList<>();
        waterQ = new LinkedList<>();
        visited = new boolean[R][C];
        sb = new StringBuilder();
        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j]=='S') {
                    hedgehogQ.add(new Pos(i, j, 0));
                    visited[i][j] = true;
                }
                if(map[i][j]=='*') waterQ.add(new Pos(i, j, 0));
            }
        }
        answer = 0;
        bfs();
        if(answer==0) sb.append("KAKTUS").append('\n');
        else sb.append(answer).append('\n');
        System.out.println(sb);
    }
    private static void bfs(){

        while(!hedgehogQ.isEmpty()){
            // 물 먼저, 도치가 먼저 가면 물에 뛰어드는 것과 같음
            int size = waterQ.size();
            // 물이 여러군데 있으므로 반복문
            for(int i=0; i< size; i++){
                Pos p  = waterQ.poll();
                for(int j=0; j<4; j++){
                    int nr = p.r + dir[j][0];
                    int nc = p.c + dir[j][1];
                    if(nr<0 || nc<0 || nr>R-1 || nc>C-1) continue;
                    if(map[nr][nc]=='.'){
                        map[nr][nc] = '*';
                        waterQ.add(new Pos(nr, nc, 0));
                    }
                }
            }

            size = hedgehogQ.size();
            // 반복문이 없으면 1초에 한 군데 가는 경우만 체크됨
            for(int i=0; i<size; i++){
                Pos p = hedgehogQ.poll();
                for(int j=0; j<4; j++){
                    int nr = p.r + dir[j][0];
                    int nc = p.c + dir[j][1];

                    if(nr<0 || nc<0 || nr>R-1 || nc>C-1) continue;
                    if(map[nr][nc]=='D') {
                        answer = p.time + 1;
                        return;
                    }
                    if(visited[nr][nc]) continue;
                    if(map[nr][nc] =='.'){
                        //map[nr][nc] = 'S';
                        visited[nr][nc] = true;
                        hedgehogQ.add(new Pos(nr, nc, p.time+1));
                    }
                }
            }

        }
    }
    static class Pos{
        int r, c, time;
        public Pos(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}