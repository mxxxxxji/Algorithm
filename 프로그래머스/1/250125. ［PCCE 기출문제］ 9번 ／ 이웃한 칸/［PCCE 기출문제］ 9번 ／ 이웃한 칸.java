class Solution {
    static int[][] dir = {{-1,0}, {1, 0}, {0, 1}, {0, -1}};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int R = board.length; 
        String color = board[h][w];
        for(int i=0; i<4; i++){
            int nr = h + dir[i][0];
            int nc = w + dir[i][1];
            if(nr<0 || nc<0 || nr>R-1 || nc> R-1) continue;
            if(color.equals(board[nr][nc])) answer++;
        }
        return answer;
    }
}