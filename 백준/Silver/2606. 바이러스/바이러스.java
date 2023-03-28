import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N; //컴퓨터 수
    static int M; //쌍의 수
    static ArrayList<Integer> list[];
    static boolean visited[];
    static int res;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        res=0;
        dfs(1);
        System.out.println(res);
    }
    public static void dfs(int com){
        visited[com] = true;

        for(int i=0; i<list[com].size(); i++){
            int next = list[com].get(i);
            if(!visited[next]){
                visited[next] =true;
                dfs(next);
                res++;
            }
        }
    }
}