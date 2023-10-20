import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int cur_weight = 0;
        for(int i=0; i<truck_weights.length; i++){
            int truck = truck_weights[i];
            while(true){
                if(q.isEmpty()){ // 트럭이 비어있다면
                    q.add(truck);
                    cur_weight+=truck;
                    answer++;
                    break;
                }else if(q.size() == bridge_length){ // 다리길이와 올라간 트럭수가 같다면
                    cur_weight-= q.poll(); // 트럭하나는 내려감
            
                }else{ 
                    if(cur_weight + truck <= weight){ // 다음 트럭 올라가는게 가능하다면
                        q.add(truck);
                        cur_weight+=truck;
                        answer++;
                        break;
                    }else{
                        q.add(0); // 공간은 비어있되 0을 넣어 차가 넘어가게 하기
                        answer++;
                    }
                    
                }
            }
            
        }
        return answer+bridge_length;
    }
}