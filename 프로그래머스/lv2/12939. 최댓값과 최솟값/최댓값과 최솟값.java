import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int[] n = new int[arr.length];
        for(int i=0; i<n.length; i++){
            n[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(n);
        answer += n[0];
        answer += " ";
        answer += n[n.length-1];
        return answer;
    }
}