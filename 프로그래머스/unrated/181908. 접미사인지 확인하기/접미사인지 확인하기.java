class Solution {
    
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        if(my_string.length()<is_suffix.length()) return answer;
        else{
            if(my_string.substring(0, is_suffix.length()).equals(is_suffix)) answer=1;
            if(my_string.substring(my_string.length()-is_suffix.length(),my_string.length())
                        .equals(is_suffix)) answer = 1;
            return answer;
        }
   
        
    }
}