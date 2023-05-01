import java.util.*;
class Solution {
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    static boolean[][] visited;
    static int n,m;
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];

        answer= bfs(0, 0, maps);
   
        return answer;
    }
    public static int bfs(int y, int x, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[]{y, x, 1});// 좌표, 비용
        while(!q.isEmpty()){
            int[] p = q.poll();
            int cy = p[0];
            int cx = p[1];
            int cost = p[2];
            if(cy == n-1 && cx == m-1) return cost;
            for(int i=0; i<4; i++){
                int ny = cy + dir[i][0];
                int nx = cx + dir[i][1];
                if(ny<0 || nx<0 || ny>=n ||nx>=m) continue;
                if(visited[ny][nx]) continue;
                if(maps[ny][nx]==1){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, cost+1});
                }
            }
        }
        return -1;
    }
}