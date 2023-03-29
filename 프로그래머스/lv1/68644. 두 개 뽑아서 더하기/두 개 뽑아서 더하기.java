import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        int len = numbers.length-1;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                arr.add(numbers[i]+ numbers[j+1]);
            }
        }
        HashSet<Integer> arr2 = new HashSet<Integer>(arr);
        ArrayList<Integer> arr3 = new ArrayList<Integer>(arr2);
        
        int[] answer = new int[arr3.size()];
        for(int i=0; i<arr3.size(); i++){
            answer[i] = arr3.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}