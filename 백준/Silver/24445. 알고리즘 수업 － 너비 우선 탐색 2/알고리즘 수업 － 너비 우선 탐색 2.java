import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,R;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int[] answer;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[N+1];
        answer = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }
        for(int i=1; i<N+1; i++){
            Collections.sort(list.get(i), Collections.reverseOrder());
        }
        cnt=1;
        bfs(R);
        for(int i=1; i<N+1; i++){
            sb.append(answer[i]).append('\n');
        }
        System.out.print(sb);
    }
    private static void bfs(int r){
        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        visited[r] = true;
        answer[r] = cnt;
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i=0; i<list.get(p).size(); i++){
                int next =  list.get(p).get(i);
                if(visited[next]) continue;
                visited[next] = true;
                cnt++;
                answer[next] = cnt;
                q.add(next);
            }
        }
    }
}