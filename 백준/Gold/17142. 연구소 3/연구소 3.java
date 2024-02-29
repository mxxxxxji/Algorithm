import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static ArrayList<Node> list;
    static Node[] virusPos;
    static boolean[] visited;
    static int minTime = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        list = new ArrayList<>();
        virusPos = new Node[M];
        int countVirus = 0;
        int emptySpace = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    list.add(new Node(i, j));
                    map[i][j] = -1;
                    countVirus++;
                }
                if(map[i][j]==0){
                    emptySpace++;
                }
            }
        }
        visited = new boolean[list.size()];
        if(countVirus==0 || emptySpace==0) System.out.println(0);
        else{
            putVirus(0, 0);
            if(minTime == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(minTime);
        }
    }
    // 모든 연구소 칸이 감염되었는가
    private static boolean check(int[][] temp, boolean[][] visited){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(temp[i][j]==0 && !visited[i][j]) return false;
            }
        }
        return true;
    }
    private static void spreadVirus(int[][] temp){
        Queue<Node> q = new LinkedList<>();
        boolean[][] check = new boolean[N][N];
        for(int i=0; i<M; i++){
            q.add(virusPos[i]);
            temp[virusPos[i].r][virusPos[i].c] = 2;
            check[virusPos[i].r][virusPos[i].c] = true;
        }
        
        int time=0;
        while(!q.isEmpty()){
            if(minTime<=time) return;
            int len = q.size();
            for(int i=0; i<len; i++){
                Node p = q.poll();
                for(int j=0; j<4; j++){
                    int nr = p.r + dir[j][0];
                    int nc = p.c + dir[j][1];

                    if(nr<0 || nc<0 || nr>N-1 || nc>N-1) continue;
                    if(check[nr][nc]) continue;
                    if(temp[nr][nc]==1) continue;
                    check[nr][nc] = true;
                    temp[nr][nc] = 2;
                    q.add(new Node(nr, nc));
                }
            }
            time++;
            if(check(temp, check)) break;
        }
        if(check(temp, check)) minTime = Math.min(time, minTime);
    }
    private static void putVirus(int depth, int start){
        if(depth==M){
            int[][] temp = copyMap();
            spreadVirus(temp);
            return;
        }
        for(int i=start; i<list.size(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            virusPos[depth] = list.get(i);
            putVirus(depth+1, i+1);
            visited[i] = false;
        }
    }
    private static int[][] copyMap(){
        int[][] copy = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }
    static class Node{
        int r, c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}