import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        int[] count = {0,0,0};
        
        // 점수 계산
        for(int i=0; i<answers.length; i++){
            if(first[i%first.length] == answers[i]) count[0]++;
            if(second[i%second.length] == answers[i]) count[1]++;
            if(third[i%third.length] == answers[i]) count[2]++;
        }
        
        // 최대 점수 구하기
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        
        // 최대 점수를 가진 수포자 리스트에 저장
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<count.length; i++) if(max==count[i]) list.add(i+1);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) answer[i] = list.get(i);
        return answer;
    }
}