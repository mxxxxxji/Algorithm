import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int n;
    static int[] answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i=1; i<N+1; i++){
            Collections.sort(list.get(i), Collections.reverseOrder());
        }
        n=1;
        dfs(R);

        for(int i=1; i<N+1; i++){
            System.out.println(answer[i]);
        }

    }
    public static void dfs(int v){
        visited[v] = true;
        answer[v]=n;

        for(int i=0; i<list.get(v).size(); i++){
            int next =  list.get(v).get(i);
            if(!visited[next]){
                n++;
                dfs(next);
            }
        }
    }
}