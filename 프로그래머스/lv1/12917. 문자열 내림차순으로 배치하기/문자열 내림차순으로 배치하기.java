import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] cArr = s.toCharArray();
        Arrays.sort(cArr);
        answer = new StringBuilder(new String(cArr)).reverse().toString();
        
        return answer;
    }
}