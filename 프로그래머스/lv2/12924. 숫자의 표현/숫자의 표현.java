class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum=0;
        if(n==1) answer=1;
        else{
            for(int i=1; i<=n; i+=1){
                for(int j=i; j<=n; j+=1){
                    sum += j;

                    if(sum==n){
                        sum=0;
                        answer+=1;

                        break;

                    }
                    if(sum>n){
                        sum=0;             
                        break;

                    }
                }

            }
        }
        
        return answer;
    }
    
}