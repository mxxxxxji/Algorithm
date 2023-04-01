import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T;
    static int N;
    static Pos[] point;
    static boolean[] visited;
    static List<List<Integer>> list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int tc = 0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            point = new Pos[N+2];
            visited = new boolean[N+2];

            list = new ArrayList<>();
            for(int i=0; i<N+2; i++){
                list.add(new ArrayList<>());
            }

            for(int i=0; i<N+2; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                point[i] = new Pos(x, y);
            }
            // 맨해튼 거리 계산
            for(int i=0; i< point.length-1; i++){
                for(int j=i+1; j< point.length; j++){
                    int manhattan = Math.abs(point[i].y-point[j].y) + Math.abs(point[i].x-point[j].x);
                    if(manhattan<=1000){
                        list.get(i).add(j);
                        list.get(j).add(i);
                    }
                }
            }
            sb.append(bfs()).append("\n");
        }
        // 1박스 20개, 50m 1병
        System.out.print(sb);
    }
    static String bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int p = q.poll();

            if(p == N+1) return "happy";

            for(int i=0; i<list.get(p).size(); i++){
                int next = list.get(p).get(i);
                if(visited[next]) continue;
                visited[next] = true;
                q.add(next);
            }
        }
        return "sad";
    }
    static class Pos{
        int y;
        int x;
        public Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}