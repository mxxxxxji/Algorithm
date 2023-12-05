import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
    Queue<String> pq = new LinkedList<>();
        for(int i=0; i<strArr.length; i++){
            if(strArr[i].indexOf("ad")==-1){
                pq.add(strArr[i]);
            }
        }
        String[] answer = new String[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx] = pq.poll();
            idx++;
        }
        return answer;
    }
}