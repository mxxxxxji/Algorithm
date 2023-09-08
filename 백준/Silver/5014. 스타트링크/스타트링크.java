import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static int min = Integer.MAX_VALUE;
    static int[] dist;
    static int[] dir = new int[2];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = -Integer.parseInt(st.nextToken());
        dist = new int[F+1];
        bfs();
    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[F+1];
        q.add(S);
        visited[S] = true;
        dist[S] = 0;
        while(!q.isEmpty()){
            int p = q.poll();
            if(p == G) {
                System.out.println(dist[p]);
                return;
            }
            for(int i=0; i<2; i++){
                int next = p + dir[i];
                if(next<1 || next>F) continue;
                if(visited[next]) continue;
                visited[next] = true;
                dist[next] = dist[p] + 1;
                q.add(next);
            }
        }
        System.out.println("use the stairs");
    }
}