import java.awt.image.VolatileImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<int[]>[] list;
    static boolean[] visited;
    static int max = 0;
    static int maxNode = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while(true){
                int e = Integer.parseInt(st.nextToken());
                if(e==-1) break;
                int w = Integer.parseInt(st.nextToken());
                list[v].add(new int[]{e, w});
            }
        }

        dfs(1, 0);

        visited = new boolean[N+1];
        visited[maxNode] = true;
        max = 0;
        dfs(maxNode, 0);

        System.out.println(max);
    }

    static void dfs(int n, int value){

        if(max<value){
            max = value;
            maxNode = n;
            //return;
        }
        for(int i=0; i<list[n].size(); i++){
            int next = list[n].get(i)[0];
            int w = list[n].get(i)[1];

            if(visited[next])continue;
            //System.out.println(n+"->"+next+"," +value);
            visited[next] = true;
            dfs(next, value+w);
        }
    }
}