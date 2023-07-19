import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> list;
    static int[][] visited;
    static int[] score;
    static int a, b;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        visited = new int[N+1][N+1];
        score = new int[N+1];
        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1) break;
            list.get(a).add(b);
            list.get(b).add(a);
        }
        for(int i=1; i<=N; i++){
            bfs(i);
        }

        int score_min = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++){
            int max = Integer.MIN_VALUE;
            for(int j=1; j<=N; j++){
                if(visited[i][j]<2) continue;
                max = Math.max(max, visited[i][j]);
            }
            score[i] = max;
            score_min = Math.min(score_min, max);
        }

        int cnt=0;
        for(int i=1; i<=N; i++){
            if(score_min!=score[i]) continue;
            cnt++;
            sb.append(i).append(' ');
        }
        System.out.println(score_min-1+" "+cnt);
        System.out.print(sb);
    }
    public static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s][s] = 1;
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i=0; i<list.get(p).size(); i++){
                int next = list.get(p).get(i);
                if(visited[s][next]!=0) continue;
                visited[s][next] = visited[s][p] + 1;
                q.add(next);
            }
        }
    }






}