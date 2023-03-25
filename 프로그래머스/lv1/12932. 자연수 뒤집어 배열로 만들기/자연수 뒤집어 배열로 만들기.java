class Solution {
    public int[] solution(long n) {
        
        int[] temp = new int[11];
        int i=0; 
        while(n>0){
            temp[i]=(int)(n%10);
            n/=10;
            i++;
        }
        int[] answer = new int[i];
        for(int j=0; j<i; j++){
            answer[j] = temp[j];
        }
        return answer;
    }
}