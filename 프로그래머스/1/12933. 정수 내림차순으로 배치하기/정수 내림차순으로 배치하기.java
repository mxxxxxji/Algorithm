import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        char[] c = s.toCharArray();
        Arrays.sort(c);
        s = "";
        for(int i=c.length-1; i>=0; i--){
            s+=String.valueOf(c[i]);
        }

        answer = Long.parseLong(s);
        return answer;
    }
}