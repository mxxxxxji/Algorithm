import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        char[] cArr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<cArr.length; i++){
            char c = cArr[i];
            if(st.isEmpty()) st.push(c);
            else{
                if(st.peek()==c) st.pop();
                else st.push(c);
            }
        }
        if(st.isEmpty()) answer = 1;
        else answer = 0;
        return answer;
    }
}