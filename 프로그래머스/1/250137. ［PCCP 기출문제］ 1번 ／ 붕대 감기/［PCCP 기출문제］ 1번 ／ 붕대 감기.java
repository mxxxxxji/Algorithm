class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        // 공격당한 후 기술이 취소되거나 끝나면 붕대감기, 연속 성공 시간 0으로 초기화
        int time = 0; // 시간
        int idx=0;
        int success_time = 0;
        while(idx<attacks.length){

            // 공격이 있다면
            if(time==attacks[idx][0]){
                answer -= attacks[idx][1];
                success_time=0;
                idx++;
            }else{                
                // 최대 체력보다 작다면
                if(answer<health){
                    answer+=bandage[1];
                    success_time++;
                    // 연속 시전 성공
                    if(success_time==bandage[0]){
                        answer+= bandage[2];
                        success_time = 0;
                    }                    
                }                                   
            }
            // 죽으면
            if(answer<=0) return -1;
            // 최대 체력 넘는다면
            if(answer>health) answer = health;
            time++;
        }
        
        
        return answer;
    }
}