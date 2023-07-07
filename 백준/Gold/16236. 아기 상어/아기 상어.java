import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] check;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int y, x;
    static int len;
    static int min_dist;
    static int min_r, min_c;
    static int shark_size=2;
    static int eat_cnt=0;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        check = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    y = i;
                    x = j;
                    map[i][j] = 0;
                }
            }
        }
        while(true){
            init();
            bfs(y, x); // 가장 가까운 거리의 상어를 먹음

            if(min_r==N ||min_c==N) break;

            result += check[min_r][min_c];
            eat_cnt++;
            if(eat_cnt == shark_size){
                shark_size++;
                eat_cnt=0;
            }
            map[min_r][min_c] = 0; // 상어 먹은곳 0으로 변경

            y = min_r;
            x = min_c;
        }
        System.out.println(result);
    }
    public static void init(){
        min_r = N;
        min_c = N;
        min_dist = N*N;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                check[i][j] = -1;
            }
        }
    }
    public static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        check[r][c] = 0; // 방문
        q.add(new int[]{r, c});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            r = cur[0];
            c = cur[1];

            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr<0 || nc<0 || nr>N-1 || nc>N-1) continue;
                if(check[nr][nc]!=-1 || map[nr][nc] > shark_size) continue;

                check[nr][nc] = check[r][c]+1; // 거리+1
                // 물고기가 상어보다 작으면
                if(map[nr][nc] !=0 && map[nr][nc] < shark_size){
                    if(min_dist > check[nr][nc]){
                        min_r = nr;
                        min_c = nc;
                        min_dist = check[nr][nc];
                    }
                    // 먹을 수 있는 물고기의 거리가 같을 때
                    else if(min_dist == check[nr][nc]) {
                        // 먹을 수 있는 물고기의 r 위치가 같을 때
                        if (min_r == nr) {
                            // 가장 왼쪽의 물고기 선택
                            if (min_c > nc) {
                                min_r = nr;
                                min_c = nc;
                            }
                        } else if (min_r > nr) {
                            min_r = nr;
                            min_c = nc;
                        }
                    }
                }
                q.add(new int[]{nr, nc});
            }

        }
    }
}