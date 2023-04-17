class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zero = 0;
        for(int i=0; i<lottos.length; i++){
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i]==win_nums[j]) cnt++;
            }
            if(lottos[i]==0) zero++;
        }
        if(zero+cnt<2) answer[0]=6;
        else answer[0] = 7-zero-cnt;
        if(cnt<2) answer[1]=6;
        else answer[1] = 7-cnt;
        return answer;
    }
}