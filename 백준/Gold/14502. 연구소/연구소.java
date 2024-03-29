import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){;
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 벽 세우기
        createWall(0);
        System.out.println(max);
    }
    private static void spreadVirus(){
        int[][] temp = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        // 바이러스 큐에 넣기, 기존 배열 복사
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                temp[i][j] = map[i][j];
                if(map[i][j]==2){
                    q.add(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] p = q.poll();
            for(int i=0; i<4; i++){
                int nr = p[0] + dir[i][0];
                int nc = p[1] + dir[i][1];
                if(nr<0 || nc<0 || nr>N-1 || nc>M-1) continue;
                if(temp[nr][nc]==0){
                    temp[nr][nc] = 2;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        // 안전영역세기
        int safe=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if (temp[i][j] == 0) safe++;
            }
        }
        max = Math.max(max, safe);
    }
    private static void createWall(int count){
        // 벽 3개 다 세우면
        if(count == 3){
            // 바이러스 퍼트려서 안전영역 세기
            spreadVirus();
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    createWall(count+1);
                    map[i][j] = 0;
                }
            }
        }
    }
}