import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<prices.length; i++){
            // 비어있지 않다면
            while(!st.isEmpty()&&prices[i]<prices[st.peek()]){
                int top = st.peek();
            
                answer[top] = i - top;
                st.pop();
                
                
            }
            // stack이 비어있다면
            st.push(i);
        }
        
        while(!st.isEmpty()){
            int top = st.peek();
            answer[top] = prices.length - top -1;
            st.pop();
        }
        return answer;
    }
}