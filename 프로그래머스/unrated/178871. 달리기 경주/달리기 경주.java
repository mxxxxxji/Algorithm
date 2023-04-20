import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
      
        Map<String, Integer> rank = new HashMap<>();
        for(int i=0; i<players.length; i++){
            rank.put(players[i], i);
        }
        for(int i=0; i<callings.length; i++){
            int a = rank.get(callings[i]); // 불린선수 원래 순위
            String b = players[a-1]; // 불린선수의 앞 선수
            players[a-1] = callings[i]; // 앞선수 순위에 불린선수 이름
            players[a] = b; // 불린선수 순위에 앞선수
            // 순위 바꿔서 저장
            rank.put(callings[i], a-1); 
            rank.put(b, a);
        }
        return players;
    }
}