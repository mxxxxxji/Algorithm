class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int countP = 0;
        int countY = 0;
        for(int i=0; i<s.length(); i++){
         
            if('p' == s.charAt(i) ||  'P'== s.charAt(i)) countP++;
            if('y' == s.charAt(i) ||  'Y'==s.charAt(i)) countY++;
        }
      
        if(countP!=countY) answer=false;
        return answer;
    }
}