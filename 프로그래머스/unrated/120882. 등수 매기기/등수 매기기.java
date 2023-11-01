import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        
        List<Integer> list = new ArrayList<>();
        for(int[] s : score){
            list.add(s[0]+s[1]);
        }
        
        int[] answer = new int[score.length];
        for(int i=0; i<answer.length; i++){
            int rank = 1;
            for(int j=0; j<answer.length; j++){
                if(list.get(i)<list.get(j)) rank++;
            }
            answer[i] = rank;
        }
        return answer;
    }
}