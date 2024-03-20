class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int cur_health = health;
        int time = 0;
        int cast_cnt = 0;
        int idx = 0;
        while(idx<attacks.length){
            
            
            if(time == attacks[idx][0]){ // 공격이 있다면
                 cast_cnt=0; // 연속 시전 실패
                cur_health -= attacks[idx][1];
                idx+=1;
            }else{
               
                if(cur_health<health){
                     // 초당 회복
                    cur_health+=bandage[1];
                    cast_cnt++;
                    // 연속 성공
                    if(cast_cnt==bandage[0]){
                        cur_health+=bandage[2];
                        cast_cnt = 0;
                    }
                    
                }else{
                    //if(cast_cnt>=bandage[0]){
                        cast_cnt=0;
                   // }
                }
                
            }
            
                   if(cur_health<=0) return -1;
            // 초기체력을 넘을 수 없다.
            if(cur_health>health) cur_health = health;
            time++;
            
           
        }
        if(cur_health<=0) return -1;
        else return cur_health;
    }
}