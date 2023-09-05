import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static int[][] map;
    static int[][] dist;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int result=-1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j)-'0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();
        System.out.println(result);
    }
    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0,1});
        dist[0][0] = 0; // 부순 벽의 개수
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0]; int c = p[1];
            int block = p[2]; int count = p[3];
            if(r==N-1&& c==M-1){
                result = count;
                break;
            }
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr<0 || nc<0 || nr>N-1|| nc>M-1) continue;
//                if(dist[nr][nc]>K) continue;
                if(dist[nr][nc]<=block) continue;
                if(map[nr][nc] == 1){
                    if(dist[nr][nc]>block+1 && block<K){
                        dist[nr][nc] = block+1;
                        q.add(new int[]{nr, nc, block+1, count+1});
                    }
                }else{
                    dist[nr][nc] = block;
                    q.add(new int[]{nr, nc, block, count+1});
                }
            }
        }
    }
}