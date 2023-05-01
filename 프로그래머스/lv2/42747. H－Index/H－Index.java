import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
       
        for(int i=0; i<citations.length; i++){
            int h = citations.length-i;
            if(citations[i]>=h) {
                answer = h;
                break;
            }
        }
        
        
        return answer;
        //0 1 3 5 6
        //0 1 2 3 4 h=1
        //0 0 1 2 3 h=2
        //0 0 1 2 3 h=3
        //0 0 0 1 2 h=4
    }
}