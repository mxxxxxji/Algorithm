import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int[][][] dir2 = {{{0,-1}, {0,1}, {-1,0}},//ㅗ
                                {{0,-1}, {0,1}, {1,0}},//ㅜ
                                {{0,-1}, {-1,0}, {1,0}}, //ㅓ
                                {{0,1}, {-1,0}, {1,0}}};//ㅏ
    static int max;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        sb = new StringBuilder();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // ㅗ ㅓ ㅜ ㅏ 모양 먼저 검사
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int d = 0; d<4; d++){
                    int value = arr[i][j];
                    for(int k=0; k<3; k++){
                        int dy = i + dir2[d][k][0];
                        int dx = j + dir2[d][k][1];
                        if(dy<0 || dx<0 || dy>N-1 || dx>M-1) break;
                        value+= arr[dy][dx];
                    }
                    if(max<value) max = value;
                }

            }
        }

        // 나머지 모양 검사
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }
    static void dfs(int y, int x, int count, int value){

        if(count == 4){
            if(max<value) max = value;
            return;
        }

        for(int i=0; i<4; i++){
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];

            if(dy<0 || dx<0 || dy>N-1 || dx>M-1) continue;
            if(visited[dy][dx]) continue;
            visited[dy][dx] = true;
            dfs(dy, dx, count+1, value+arr[dy][dx]);
            visited[dy][dx] = false;
        }
    }
}