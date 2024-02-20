import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws Exception {
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
            list.get(b).add(a);
        }

        X = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        visited[X] = true;
        dfs(X);
        System.out.println(answer);
        br.close();
    }
    static void dfs(int work){

        for(int i=0; i<list.get(work).size(); i++){
            int next = list.get(work).get(i);
            if(visited[next]) continue;
            visited[next] = true;
            answer++;
            dfs(next);
        }
    }
}