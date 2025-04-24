class Solution {
    private static final int[] dy = {1, 0, -1};
    private static final int[] dx = {0, 1, -1};
    public int[] solution(int n) {
        
        int[][] tgl = new int[n][n];
        int y = 0;
        int x = 0;
        int v = 1; // 배열에 채워 넣을 수
        int d = 0; // 방향
        while(true){
            tgl[y][x] = v++;
            
            int ny = y + dy[d];
            int nx = x + dx[d];
            
        
            if(ny==n || nx==n || nx==-1 || ny==-1 || tgl[ny][nx]!=0) {
                d = (d+1) % 3;
                ny = y + dy[d];
                nx = x + dx[d];
                // 방향을 틀었을 때도 갈 곳이 없다면
                if(ny==n || nx==n || nx==-1 || ny==-1 || tgl[ny][nx]!=0) break;
                
               
            }
            y = ny;
            x = nx;
        }
        int[] answer = new int[v-1];
        int idx = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                answer[idx++] = tgl[i][j];
            }
        }
        return answer;
    }
}