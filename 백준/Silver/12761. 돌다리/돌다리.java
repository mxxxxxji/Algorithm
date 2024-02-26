import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int A, B, N, M;
    static int minCnt;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        minCnt = Integer.MAX_VALUE;
        visited = new boolean[100001];
     
        bfs();
        System.out.print(minCnt);
    }

    private static void bfs(){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        visited[N] = true;
        while(!q.isEmpty()){
            int[] p = q.poll();

            int value = p[0];
            int cnt = p[1];

            int[] dir = {value-1, value+1, value+A, value+B, value-A, value-B, value*A, value*B};
            
            if(value == M){
                if(minCnt>cnt){
                    minCnt = cnt;
                }
                break;
            }

            for(int i=0; i<8; i++){
                if(dir[i]<0 || dir[i]>100000) continue;
                if(visited[dir[i]]) continue;
                visited[dir[i]] = true;
                q.add(new int[]{dir[i], cnt+1});
            }

        }
    }
}