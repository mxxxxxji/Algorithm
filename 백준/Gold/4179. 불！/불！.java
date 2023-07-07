import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static String[][] map;
    static boolean[][] visitedF;
    static boolean[][] visitedJ;
    static int jy, jx; // 시작 위치
    static int fy, fx; // 불난 우치
    static int dir[][] = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
    static int answer = 0;
    static Queue<int[]> qj;
    static Queue<int[]> qf;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        visitedF = new boolean[R][C];
        visitedJ = new boolean[R][C];

        qj = new LinkedList<>();
        qf = new LinkedList<>();

        for(int i=0; i<R; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<C; j++){
                map[i][j] = s[j];
                if(map[i][j].equals("J")) {
                    map[i][j] = ".";
                    qj.add(new int[]{i, j});
                    visitedJ[i][j] = true;
                }
                else if(map[i][j].equals("F")){
                    qf.add(new int[]{i, j});
                    visitedF[i][j] = true;
                }
            }
        }
        bfs();

//        for(int i=0; i<R; i++){
//            for(int j=0; j<C; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println("IMPOSSIBLE");

    }
    private static void bfs(){

        while(!qj.isEmpty()){
            int jLen = qj.size();
            int fLen = qf.size();
            for(int i=0; i<fLen; i++){
                int[] fire = qf.poll();
                for(int j=0; j<4; j++){
                    int nr = fire[0] + dir[j][0];
                    int nc = fire[1] + dir[j][1];

                    if(nr<0||nc<0||nr>R-1||nc>C-1) continue;
                    if(visitedF[nr][nc]) continue;
                    if(map[nr][nc].equals("#")) continue;
                    map[nr][nc] = "F";
                    visitedF[nr][nc] = true;
                    qf.add(new int[]{nr, nc});
                }

            }
            for(int i=0; i<jLen; i++){
                int[] ji = qj.poll();

                for(int j=0; j<4; j++){
                    int nr = ji[0] + dir[j][0];
                    int nc = ji[1] + dir[j][1];

                    if(nr<0||nc<0||nr>R-1||nc>C-1) {
                        answer++;
                        System.out.println(answer);
                        System.exit(0);
                    }
                    if(!map[nr][nc].equals(".")) continue;
                    if(visitedJ[nr][nc]) continue;
                    visitedJ[nr][nc] = true;
                    qj.add(new int[]{nr, nc});

                }
            }

            answer++;
        }
    }
}