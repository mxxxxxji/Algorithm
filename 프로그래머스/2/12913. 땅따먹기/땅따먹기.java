class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp = new int[land.length][land[0].length];
        for(int i=0; i<4; i++){
            dp[0][i] = land[0][i];
    
        }
        for(int row=0; row<land.length-1; row++){
            // 이전행
            for(int i=0; i<4; i++){
                int front = dp[row][i];
                // 다음행 
                for(int j=0; j<4; j++){
                    if(j!=i) {
                        int next = front + land[row+1][j];
                        if(next>dp[row+1][j]) dp[row+1][j] = next;
                    }
                }
            }
        }
        for(int i=0; i<4; i++){
            answer = Math.max(answer, dp[land.length-1][i]);
        }
        return answer;
    }
}