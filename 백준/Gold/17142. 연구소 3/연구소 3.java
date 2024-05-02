import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<Node> list;
    static boolean[] visited;
    static Node[] virusPos;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int minTime = Integer.MAX_VALUE;
    public static void main(String[] arags) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        list =  new ArrayList<>();
        int emptySpace=0;
        int virusCount=0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    list.add(new Node(i, j));
                    virusCount++;
                }
                if(map[i][j]==0){
                    emptySpace++;
                }
            }
        }
        visited = new boolean[list.size()];
        virusPos = new Node[M];
        spreadVirus(0, 0);
        if(emptySpace==0) System.out.println(0);
        else {
            if(minTime==Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(minTime);
        }

    }
    static int[][] copyMap(){
        int[][] copy = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }
    static boolean check(int[][] temp){

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(temp[i][j]==0) return false;
            }
        }
        return true;
    }
    static void putVirus(int[][] curMap){
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<M; i++) {
            q.add(new Node(virusPos[i].r, virusPos[i].c));
            curMap[virusPos[i].r][virusPos[i].c] = 3; // 활성산소
        }
        int time = 0;
        while(!q.isEmpty()){
            if(minTime<=time) break;
            int size = q.size();
            for(int i=0; i<size; i++){
                Node node = q.poll();
                for(int j=0; j<4; j++){
                    int nr = node.r + dir[j][0];
                    int nc = node.c + dir[j][1];

                    if(nr<0 || nc<0 || nr>N-1|| nc>N-1) continue; //지도 밖
                    if(curMap[nr][nc]==1) continue; // 벽이면
                    if(curMap[nr][nc]==3) continue; //이미 활성바이러스, 방문했다는 뜻
                    curMap[nr][nc]=3;
                    q.add(new Node(nr, nc));
                }
            }
            time++;
            if(check(curMap)) minTime = Math.min(time, minTime);
        }
        if(check(curMap)) minTime = Math.min(time, minTime);
    }
    static void spreadVirus(int depth, int start){
        if(depth == M) {
            int[][] temp = copyMap();
            putVirus(temp);
            return;
        }

        for(int i=start; i<list.size(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            virusPos[depth] = list.get(i);
            spreadVirus(depth+1, i+1);
            visited[i] = false;
        }

    }    static class Node{
        int r, c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}