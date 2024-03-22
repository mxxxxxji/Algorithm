import java.util.*;
class Solution {
    static int[][] visited;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int R, C;
    static ArrayList<Integer> oil;
    public int solution(int[][] land) {
        int answer = 0;
        R = land.length; // 세로, 행 갯수
        C = land[0].length; // 가로, 열 갯수
        
        visited = new int[R][C];
        oil = new ArrayList<>();
        int cnt = 1;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(land[i][j]==0) continue;
                if(visited[i][j]!=0) continue;
                bfs(i, j, cnt, land);
         
                cnt++;
            }
        }
        
    
        int max_sum = Integer.MIN_VALUE;
        
        for(int i=0; i<C; i++){
            int sum = 0;
            boolean[] oil_visited = new boolean[oil.size()];
            for(int j=0; j<R; j++){
                int number = visited[j][i];
                if(land[j][i]!=0 && !oil_visited[number-1]) {
                    oil_visited[number-1] = true;
                    sum += oil.get(number-1);
                }
            }
            max_sum = Math.max(sum, max_sum);
        }
        answer = max_sum;
        return answer;
    }
    static void bfs(int r, int c, int n, int[][] land){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = n;
        int amount=1;
        while(!q.isEmpty()){
            int[] p = q.poll();
            
            for(int i=0; i<4; i++){
                int nr = p[0] + dir[i][0];
                int nc = p[1] + dir[i][1];
                
                if(nr<0 || nr>R-1 || nc<0 || nc>C-1) continue;
                if(visited[nr][nc]!=0) continue;
                if(land[nr][nc]==0) continue;
                visited[nr][nc] = n;
                amount++;
                q.add(new int[]{nr, nc});
            }
        }
        oil.add(amount);
    }
}