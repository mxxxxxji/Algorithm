import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = new int[N+1];

        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=1; i<graph.length; i++){
            //if(graph[i].size()!=0)
            Collections.sort(graph[i]);
        }
        n=1;
        dfs(R);
        for(int i=1; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }
    public static void dfs(int x){
        visited[x] = true;

        answer[x] = n;
        for(int i=0; i<graph[x].size(); i++){
            int next = graph[x].get(i);
            if(!visited[next]){
                n++;
                visited[next] = true;
                dfs(next);
            }
        }
    }
}