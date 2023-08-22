import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<int[]> list;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{s, b});
        }
        for(int i=0; i<list.size(); i++){
            visited = new boolean[N];
            dfs(i, list.get(i)[0], list.get(i)[1]);
        }

        System.out.println(min);
    }
    static void dfs(int num, int flavorS, int flavorB) {
        min = Math.min(min, Math.abs(flavorB-flavorS));
        visited[num] = true;
        for(int i=0; i<list.size(); i++){
            if(visited[i])continue;
            visited[i] = true;
            dfs(i, flavorS * list.get(i)[0], flavorB + list.get(i)[1]);
            visited[i] = false;
        }
    }
}