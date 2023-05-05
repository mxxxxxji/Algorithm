import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        
        // 개수(value)가 많은 순으로 정렬
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2)-> o2.getValue().compareTo(o1.getValue()));
        
        for(Map.Entry<Integer, Integer> entry : list){
            if(k<=0) break;
            answer++;
            k-=entry.getValue();
            
        }
        return answer;
    }
}