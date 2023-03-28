class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int idx = phone_number.length();
        String start = phone_number.substring(0, idx-4);
        String end = phone_number.substring(idx-4, idx);
        for(int i=0; i<start.length(); i++){
            answer += "*";
        }
        answer += end;
        return answer;
    }
}