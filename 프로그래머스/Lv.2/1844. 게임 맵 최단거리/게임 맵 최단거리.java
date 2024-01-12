import java.util.*;
class Solution {
    static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static boolean[][] visited;
    static int n,m;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        int answer = 0;
        answer =bfs(0, 0, maps);
        return answer;
    }
    private static int bfs(int y, int x, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x,1});
        visited[y][x] = true;
        
        while(!q.isEmpty()){
            int[]p = q.poll();
            int r = p[0]; 
            int c = p[1]; 
            int cost = p[2];
            
            if(r== n-1 && c == m-1) return cost;
            
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
        
                if(nr<0 || nc<0 || nr>n-1 || nc> m-1) continue;
                if(maps[nr][nc]==0) continue;
                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, cost+1});
            }
        }
        return -1;
    }
}