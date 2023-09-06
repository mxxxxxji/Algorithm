import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static boolean res;
    static final int RED = 1;
    static final int BLUE = -1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        //System.out.println(K);
        for(int tc = 0; tc<K; tc++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
           // System.out.println( V+", "+E);
            graph = new ArrayList<>();
            visited = new int[V+1];
            res = true;

            for(int i=0; i<V+1; i++){
                graph.add(new ArrayList<Integer>());
                visited[i] = 0;
            }
            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
               // System.out.println(a+", "+b);
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for(int i=1; i<V+1; i++){
                if(!res) break;
                if(visited[i]==0) {
                    dfs(i, RED);
                }

            }
            System.out.println(res ? "YES" :"NO");
        }
    }
    static void dfs(int start, int color){
        visited[start] = color;
//        for (int adjV : graph.get(start)) {
//            // 시작 정점의 색과 인접한 정점의 색이 같으면 이분 그래프가 아니다.
//            if (visited[adjV] == color) {
//                res = false;
//                return;
//            }
//
//            // 시작 정점과 인접한 정점이 방문하지 않은 정점이면 dfs 실행
//            if (visited[adjV] == 0) {
//                // 인접한 정점을 다른 색으로 지정
//                dfs(adjV, -color);
//            }
//        }

        for(int i=0; i<graph.get(start).size(); i++){
            int next = graph.get(start).get(i);
            // 시작 정점과 인접한 정점의 색이 같으면 이분그래프 아님
            if(visited[next]==color){
                res = false;
                return;
            }

            if(visited[next]==0){
                dfs(next, -color);
            }
        }
    }
}