class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        // 약수 개수
        int[] count = new int[number];
        for(int i=0; i<number+1; i++){
            for(int j=1; j*j<=i; j++){
                if(j*j==i) count[i-1]++;
                else if(i%j==0) count[i-1] +=2;
            }
        }
        
        for(int i=0; i<number; i++){
            if(count[i]>limit) answer += power;
            else answer += count[i];
            
        }
        return answer;
    }
}