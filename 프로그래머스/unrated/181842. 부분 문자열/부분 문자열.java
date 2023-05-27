class Solution {
    public int solution(String str1, String str2) {
        int answer = str2.indexOf(str1);
        if(answer==-1) answer=0;
        else answer = 1;
        return answer;
    }
}