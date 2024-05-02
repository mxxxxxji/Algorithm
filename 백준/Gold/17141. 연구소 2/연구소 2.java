import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<Node> list; // 바이러스를 놓을 수 있는 칸(2)
    static boolean[] visited;
    static Node[] virusPos;
    static int[][] copyMap;
    static int minTime = Integer.MAX_VALUE;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        list = new ArrayList<>();
        int emptySpace = 0;
        int countVirus = 0; // 바이러스를 놓을 수 있는 칸
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    list.add(new Node(i, j));
                    countVirus++;
                    map[i][j]=0;
                }
                if(map[i][j]==0){
                    emptySpace++;
                }
            }
        }
        //System.out.println(emptySpace+", " +countVirus);
        visited = new boolean[countVirus];
        virusPos = new Node[M];
        copyMap = new int[N][N];

        // 퍼질 공간이 없다면
        if(emptySpace==0||emptySpace==M) System.out.println(0);
        else{
            putVirus(0, 0);
            if(minTime == Integer.MAX_VALUE) System.out.println(-1);
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
    //모든 연구소가 감염되었는가
    static boolean checkMap(int[][]curMap){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(curMap[i][j]==0) return false;
            }
        }
        return true;
    }
    static void spreadVirus(int[][] curMap){
        Queue<Node> q = new LinkedList<>();
        boolean[][] check = new boolean[N][N];

        // 큐에 바이러스 넣기
        for(int i=0; i<M; i++){
            q.add(virusPos[i]);
            curMap[virusPos[i].r][virusPos[i].c] = 2;
            check[virusPos[i].r][virusPos[i].c] = true;
        }

//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(curMap[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
        int time = 0;
        while(!q.isEmpty()){
            if(minTime<=time) break; // 이미 최소 시간보다 커짐
            int len = q.size();
            for(int i=0; i<len; i++){
                Node node = q.poll();
                for(int j=0; j<4; j++){
                    int nr = node.r + dir[j][0];
                    int nc = node.c + dir[j][1];

                    if(nr<0 || nc<0 || nr>N-1 || nc>N-1) continue;
                    if(curMap[nr][nc]==1) continue; // 벽이 아니거나 이미 바이러스 있는 경우
                    if(curMap[nr][nc]==2) continue;
                    curMap[nr][nc] = 2;
                    q.add(new Node(nr, nc));

                }
            }
            time++;
            if(checkMap(curMap)) break;
        }
        // 퍼질 수 있는 곳은 다 퍼졌지만 빈 공간이 남았을 수도 있기 때문에 검사
        if(checkMap(curMap))minTime = Math.min(minTime,time);

    }
    static void putVirus(int depth, int start){
        if(depth == M){
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
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }

    }
}