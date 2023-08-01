import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dustDir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] moveDir = {};
    static int airCleaner=-1;
    static Queue<int[]> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(airCleaner==-1&&map[i][j]==-1){
                    airCleaner = i;
                }
            }
        }

        int res=0;
        while(T>0){
            q = new LinkedList<>();
            // 미세먼지 확산
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j]==0 || map[i][j]==-1) continue;
                    q.add(new int[]{i, j, map[i][j]});

                }
            }
            spread();
            // 공기청정기 작동
            work();

            T--;
        }
        // 남아있는 먼지 확인
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]==-1) continue;
                res += map[i][j];
            }
        }

        System.out.println(res);
    }
    private static void spread(){
        // 인접 4방향
        // 공기청정기 외에 확산
        // 확산량 = (R,C)/5 소수점 버림
        // (R, C) = (R,C)/5 * 확산된 방향의 개수

        while(!q.isEmpty()){
            int[] now = q.poll();
            int range=0;

            int w = now[2]/5;
            for(int i=0; i<4; i++){
                int nr = now[0] + dustDir[i][0];
                int nc = now[1] + dustDir[i][1];

                if(nr<0 || nc<0 || nr>R-1 || nc>C-1) continue;
                if(map[nr][nc]==-1) continue;

                map[nr][nc] += w;
                range++;
            }
            map[now[0]][now[1]] = map[now[0]][now[1]] - w*range;
        }


    }
    private static void work(){
        // 2행 1열 차지
        // 위쪽 -  반시계 순환
        // 아래쪽 - 시계방향 순환
        // 바람의 방향대로 모두 한칸씩 이동
        // 공기 청정기로 돌아오면 먹음

        int top = airCleaner;
        int down = airCleaner + 1;

        // 위쪽 공기청정기의 바람은 반시계방향 순환,
        // 아래로 당기기
        for (int i = top - 1; i > 0; i--)
            map[i][0] = map[i-1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++)
            map[0][i] = map[0][i+1];
        // 위로 당기기
        for (int i = 0; i < top; i++)
            map[i][C - 1] = map[i + 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--)
            map[top][i] = map[top][i-1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[top][1] = 0;

        // 아래쪽 공기청정기의 바람은 시계방향으로 순환
        // 위로 당기기
        for (int i = down + 1; i < R - 1; i++)
            map[i][0] = map[i + 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++)
            map[R - 1][i] = map[R - 1][i + 1];
        // 아래로 당기기
        for (int i = R - 1; i > down; i--)
            map[i][C - 1] = map[i - 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--)
            map[down][i] = map[down][i - 1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[down][1] = 0;
    }
}