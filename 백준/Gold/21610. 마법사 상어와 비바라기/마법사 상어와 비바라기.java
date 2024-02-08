import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] cloud;
    static List<int[]> list;
    static int[][] dir = {{0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        cloud = new boolean[N][N];
        list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 초기 구름
        list.add(new int[]{N-1, 0});
        list.add(new int[]{N-1, 1});
        list.add(new int[]{N-2, 0});
        list.add(new int[]{N-2, 1});

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            cloud = new boolean[N][N];

            // 1. 구름 이동, d방향 s칸 만큼
            // 2. 비 내림, 물의 양 +1
            move(d, s);
            // 4. 물 복사
            copy();
            // 5. 구름 생성
            create();
        }
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                answer+=map[i][j];
            }
        }
        System.out.println(answer);
    }
    private static void move(int d, int s){
        for(int i=0; i<list.size(); i++){
            int r = list.get(i)[0];
            int c = list.get(i)[1];

            int nr = (r + N + dir[d][0] * s % N) % N;
            int nc = (c + N + dir[d][1] * s % N) % N;
            cloud[nr][nc] = true;

            // 비 내림
            map[nr][nc]+=1;

            list.get(i)[0] = nr;
            list.get(i)[1] = nc;


        }
    }
    private static void copy(){
        for(int i=0; i<list.size(); i++){
            int count = 0;
            int r = list.get(i)[0];
            int c = list.get(i)[1];
            for(int j=1; j<8; j+=2){
                int nr = r + dir[j][0];
                int nc = c + dir[j][1];
                if(nr<0 || nc<0 || nr>N-1 || nc>N-1) continue;
                if(map[nr][nc]>0) count++;
            }
            map[r][c]+= count;
        }
    }
    private static void create(){
        list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]<2) continue;
                if(cloud[i][j]) continue;
                list.add(new int[]{i, j});
                map[i][j] -=2;

            }
        }
    }
}