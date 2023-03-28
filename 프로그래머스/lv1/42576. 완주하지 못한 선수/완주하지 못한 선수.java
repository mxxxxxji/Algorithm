import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        	// 풀이2. 해시맵
    HashMap<String, Integer> hm = new HashMap<>();
    for(String player:participant) hm.put(player, hm.getOrDefault(player,0)+1);
    for(String player:completion) hm.put(player, hm.get(player)-1);
    
    for(String key:hm.keySet()){
        if(hm.get(key) != 0){
            answer = key;
        }
    }
    
        return answer;
    }
}