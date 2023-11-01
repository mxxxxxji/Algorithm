class Solution {
    static int[][] dir = {{0,1}, {0, -1}, {-1,0}, {1,0}};
    static int x = 0;
    static int y = 0;
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int end_x = board[0]/2;
        int end_y = board[1]/2;
        for(int i=0; i<keyinput.length; i++){
            String cmd = keyinput[i];
            int nx = 0; int ny = 0;
            if("up".equals(cmd)){
                nx = x + dir[0][0];
                ny = y + dir[0][1];
            }else if("down".equals(cmd)){
                nx = x + dir[1][0];
                ny = y + dir[1][1];
            }else if("left".equals(cmd)){
                nx = x + dir[2][0];
                ny = y + dir[2][1];
            }else{
                nx = x + dir[3][0];
                ny = y + dir[3][1];
            }
            
            if(nx<-end_x){
                nx = -end_x;
            }
            if(ny<-end_y){
                ny = -end_y;
            }
            if(nx>end_x){
                nx = end_x;
            } 
            if(ny>end_y){
               ny = end_y;
            }
            x = nx;
            y = ny;
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}