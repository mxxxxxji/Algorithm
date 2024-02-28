import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static ArrayList<Node> list; // 가능한 위치를 넣음
    static boolean[] visited;
    static Node[] virusPos;
    static int minTime = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        virusPos = new Node[M];


        list = new ArrayList<>();
        int cnt = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) {
                    list.add(new Node(i, j));
                    cnt++;
                }
            }
        }
        visited = new boolean[cnt];
        putVirus(0, 0);
        if(minTime==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minTime-1);
    }

    // 모든 연구소 칸이 감염되었는가
    private static boolean check(int[][] temp, boolean[][] visited){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(temp[i][j]!=1 &&!visited[i][j]) return false;
            }
        }
        return true;
    }
    // 배열 복사
    private static int[][] copyMap(){
        int[][] copy = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                copy[i][j] = (map[i][j]==2 ? 0 : map[i][j]);
            }
        }
        for(int i=0; i<M; i++){
            copy[virusPos[i].r][virusPos[i].c] = 2;
        }
        return copy;
    }
    private static void spreadVirus(int[][] temp){

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        // 큐에 바이러스 넣기
        for(int i=0; i<M; i++){
            q.add(new Node(virusPos[i].r, virusPos[i].c));
            visited[virusPos[i].r][virusPos[i].c] = true;
        }
        int time = 0;
        while(!q.isEmpty()){
            if(minTime<=time) break;
            int size = q.size();
            for(int i=0; i<size; i++){ // 시작 위치가 여러개
                Node node = q.poll();

                for(int j=0; j<4; j++){
                    int nr = node.r + dir[j][0];
                    int nc = node.c + dir[j][1];

                    if(nr<0 || nc<0 || nr>N-1 || nc>N-1) continue;
                    if(visited[nr][nc]) continue;
                    if(temp[nr][nc]!=1) {
                        temp[nr][nc] = 2;
                        visited[nr][nc] =true;
                        q.add(new Node(nr, nc));
                    }
                }
            }
            time++;
        }
        if(check(temp, visited)) {
            minTime = Math.min(time, minTime);
        }
    }
    // 가능한 바이러스 위치 조합
    private static void putVirus(int depth, int start){
        if(depth == M){
            int[][] copy = copyMap();
            spreadVirus(copy);
            return;
        }
        for(int i=start; i<list.size(); i++){
            if(visited[i]) continue;
            virusPos[depth] = list.get(i);
            visited[i] = true;
            putVirus(depth+1, i+1);
            visited[i] = false;
        }
    }
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}