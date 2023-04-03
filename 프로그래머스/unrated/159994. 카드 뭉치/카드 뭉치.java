class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int idx_goal=0;
        int idx1 = 0;
        int idx2 = 0;
           // System.out.println("if"+ cards1[idx1]+", "+goal[idx_goal]);
        while(idx_goal<goal.length){
            
            if(idx1<cards1.length && cards1[idx1].equals(goal[idx_goal])){
                idx1++;
                idx_goal++;
            }else if(idx2<cards2.length && cards2[idx2].equals(goal[idx_goal])){
                idx2++;
                idx_goal++;
            }else{
                break;
            }
        }
             
       
        String answer;
        if(idx_goal == goal.length) answer = "Yes";
        else answer = "No";
        return answer;
    }
}