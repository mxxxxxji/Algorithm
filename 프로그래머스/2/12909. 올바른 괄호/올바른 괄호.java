import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(st.empty()){
                st.push(c);
            }else{
                if(c==')' && st.peek()=='('){
                    st.pop();
                }else{
                    st.push(c);
                }
            }
        }
        if(st.size()>0) return false;
        else return true;

    }
}