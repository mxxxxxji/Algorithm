import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int a,b;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int res =-1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i=0; i< list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        dfs(a, 0);
        System.out.println(res);
    }
    public static void dfs(int value, int cnt){
        if(value==b){
            res = cnt;
            return;
        }
        visited[value] = true;
        for(int i=0; i<list[value].size(); i++){
            if(!visited[list[value].get(i)]){
                visited[list[value].get(i)] = true;
                dfs(list[value].get(i), cnt+1);
            }
        }

    }
}