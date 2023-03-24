import java.util.Arrays;
class Solution {
    public int[] solution(int[] array) {
        int[] answer = {0,0};
        int[] temp = array.clone();
        Arrays.sort(temp);
        answer[0] = temp[temp.length-1];
        for(int i=0; i<array.length; i++){
            if(temp[temp.length-1]==array[i]) {
                answer[1]=i;
                break;
            }
        }
        return answer;
    }
}