import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> list;
    static int[] visited;
    static int max_len = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            list.add(new ArrayList<>());
        }
        visited = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1);


        int cnt=0;
        int num=Integer.MAX_VALUE;
        for(int i=1; i<=N; i++){
            if(visited[i]!=max_len) continue;
            cnt++;
            num = Math.min(num, i);
        }
        max_len = max_len-1;
        sb.append(num).append(' ').append(max_len).append(' ').append(cnt);
        System.out.print(sb);
    }
    public static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 1;
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i=0; i<list.get(p).size(); i++){
                int next = list.get(p).get(i);
                if(visited[next]!=0) continue;
                visited[next] = visited[p]+1;
                max_len = Math.max(max_len, visited[next]);
                q.add(next);
            }
        }
    }
}