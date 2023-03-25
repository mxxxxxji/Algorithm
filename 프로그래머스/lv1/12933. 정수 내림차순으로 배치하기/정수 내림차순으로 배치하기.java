import java.util.Arrays;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        char[] c = s.toCharArray();
        Arrays.sort(c);
        s = new String(c);
        StringBuffer sb = new StringBuffer(s);
        String rs = sb.reverse().toString();
        answer = Long.parseLong(rs);
        return answer;
    }
}