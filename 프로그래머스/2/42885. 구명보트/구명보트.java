import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min_idx=0;
        int max_idx=people.length-1;
        for(int i=max_idx; i>=min_idx; i--){
            if(people[min_idx]+people[max_idx]<=limit) {
                min_idx++;
            }
            answer++; max_idx--;
        }
        return answer;
    }
}