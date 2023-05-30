class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int flag = 0;
        for(int i=1; i<words.length; i++){
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                flag = 1;
            }else{
                for(int j=0; j<i; j++){
                    if(words[i].equals(words[j])){
                        flag=1; break;
                    }
                }
            }
            if(flag==1){
                answer[1] = i/n+1;
                answer[0] = i%n+1;
                break;
            }
        }
        
        return answer;
    }
}