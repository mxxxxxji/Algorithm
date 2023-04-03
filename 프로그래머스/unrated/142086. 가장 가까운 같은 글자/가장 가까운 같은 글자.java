class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] temp = new String[s.length()];
        
        for(int i=0; i<temp.length; i++){
            temp[i] = String.valueOf(s.charAt(i));
        }
        
        for(int i=0; i<answer.length; i++){
            answer[i] = -1;    
        }
        
        for(int i=1; i<temp.length; i++){
            for(int j=0; j<i; j++){
                if(temp[i].equals(temp[j])){
                    answer[i] = i-j;
                }
            }
        }
        
        return answer;
    }
}