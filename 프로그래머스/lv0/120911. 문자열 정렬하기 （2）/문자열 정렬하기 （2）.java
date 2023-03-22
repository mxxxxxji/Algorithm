import java.util.Arrays;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        // 대문자->소문자
        answer= my_string.toLowerCase();
        // string을 char배열로
        char[] cArr = answer.toCharArray();
        // char 배열 정렬
        Arrays.sort(cArr);
        // char 배열을 string으로
        answer = new String(cArr);
        return answer;
    }
}