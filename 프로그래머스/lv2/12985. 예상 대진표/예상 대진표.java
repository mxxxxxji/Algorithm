class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1; // 총 경기 수

        while(Math.abs(b-a)!=1 || a/2==b/2){
          
            if(a%2==1){
                a = a/2+1;
            }else{
                a = a/2;
            }
            if(b%2==1){
                b = b/2+1;
            }else{
                b = b/2;
            }
            answer++;
  
        }
        return answer;
    }
}