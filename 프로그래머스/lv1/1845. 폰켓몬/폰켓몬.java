import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // 포켓몬 N마리, 종류별 번호
        // 최대한 많은 종류의 포켓몬을 포함 N/2
        HashMap<Integer,Integer> hm = new HashMap<>();
        int pick = nums.length/2;
        for(int monster:nums) hm.put(monster, hm.getOrDefault(monster, 0)+1);
        
        if(hm.size()<pick) answer = hm.size();
        else answer = pick;
        return answer;
    }
}