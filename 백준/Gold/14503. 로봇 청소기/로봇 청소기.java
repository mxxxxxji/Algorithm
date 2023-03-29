import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
    public static int[][] map;
    public static int cnt = 0;
    public static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}}; 


	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        clean(r, c, d);

        
        bw.write(cnt + "\n");
        br.close();
        bw.flush();
        bw.close();
	}
//	public static int direction(int d){
//	    if (d == 0) return 3;
//	    else if (d == 1) return 0;
//	    else if (d == 2) return 1;
//	    else return 2;
//	}


	public static void clean(int y, int x, int d) {
        // 현재 위치 청소
        if (map[y][x] == 0) {
            map[y][x] = 2;
            cnt++;
        }

        // 왼쪽방향부터 탐색
        boolean flag = false;
        int cur_d = d;
        for (int i = 0; i < 4; i++) {
            int next_d = (d+3)%4;
            int dy = y + dir[next_d][0];
            int dx = x + dir[next_d][1];

            if (dy > 0 && dx > 0 && dy < N && dx < M) {
            	 
                if (map[dy][dx] == 0) { 
                    clean(dy, dx, next_d);
                    flag = true;
                    break;
                }
              
            }
            d = (d+3)%4;
        }

        // 네 방향 모두 청소가 되어있거나 벽인 경우
        if(!flag) {
        	int next_d = (cur_d + 2) % 4;
            int dy = y + dir[next_d][0];
            int dx = x + dir[next_d][1];

            if (dy > 0 && dx > 0 && dy < N && dx < M) {
            	 if (map[dy][dx] != 1) {
                     clean(dy, dx, cur_d); 
                 }
            }
        }
    }
}