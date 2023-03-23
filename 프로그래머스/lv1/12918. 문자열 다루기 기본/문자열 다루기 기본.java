class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length()==4||s.length()==6){
            char[] cArr = s.toCharArray();
            for(int i=0; i<cArr.length; i++){
                if(cArr[i]-'0'<0 || cArr[i]-'0'>9){
                    answer = false;
                    break;
                }
            }
        }else{
            answer=false;
        }
        return answer;
    }
}