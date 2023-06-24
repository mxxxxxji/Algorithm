class Solution
{
    public int solution(String s)
    {


        // 가장 긴 문자열부터 팰린드롬 검사
        for(int i=s.length(); i>1; i--){

            // j: 시작 인덱스
            for(int j=0; j+i<=s.length(); j++){
                boolean chk = true;
                for(int k=0; k<i/2; k++){
                    if(s.charAt(j+k) != s.charAt(j+i-k-1)){
                        chk = false;
                        break;
                    }
                }
                if(chk) return i;

            }
           
        }

        return 1;
    }
   
}