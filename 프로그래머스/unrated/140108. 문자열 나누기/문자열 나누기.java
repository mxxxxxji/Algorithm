class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int same = 0;
        int diff = 0;
        for(int i=0; i<s.length(); i++){
            if(same == diff){
                same=0; diff=0;
                answer++;
                x = s.charAt(i);
            }
            if(s.charAt(i)==x) same++;
            else diff++;
            
            
        }
        return answer;
    }
}