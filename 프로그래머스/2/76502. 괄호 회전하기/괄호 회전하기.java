import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int count = 0;
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            q.add(s.charAt(i));
        }
        while(count<s.length()){
            //System.out.println(s);
            if(check(s)) answer++;
            char c = s.charAt(0);
            s = s.substring(1, s.length()) + c;
            count++;
        }
        return answer;
    }
    static boolean check(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(st.isEmpty()){
                st.push(c);
            } else if(c==')' && st.peek() == '(') {
                st.pop();
            } else if(c==']' && st.peek() == '[') {
                st.pop();  
            } else if(c=='}' && st.peek() == '{') {
                st.pop();
            } else {
                st.push(c);
            }
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}