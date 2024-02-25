import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> list;
    static int[] dist;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }


        dist = new int[N+1];

        int minValue = Integer.MAX_VALUE;
        int minValueUser = 0;

        for(int i=1; i<=N; i++){
            // 정점의 케빈 베이컨
            int cnt = bfs(i);
            // 가장 작은 값을 가진 유저
            if(cnt < minValue) {
                minValue = cnt;
                minValueUser = i;
            }
        }
        System.out.println(minValueUser);
    }
    private static int bfs(int x){
        Arrays.fill(dist, -1);
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dist[x] = 0;

        while(!q.isEmpty()){
            int p = q.poll();
            for(int next : list.get(p)){
                if(dist[next] != -1) continue;
                // next까지 최단거리
                dist[next] = dist[p]+1;
                count += dist[next];
                q.add(next);
            }
        }
        return count;
    }
}