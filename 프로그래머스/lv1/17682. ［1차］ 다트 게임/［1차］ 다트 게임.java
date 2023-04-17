class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] game = new int[4];
        String snum="";
        int idx=-1;
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            
            // 점수
            if('0'<=c&& c<='9') {
                idx++;
                snum = "";
                snum += String.valueOf(c);
                if(i>0){
                    if(dartResult.charAt(i-1)=='1' && c=='0'){
                        snum+= "10";
                        idx--;
                    }
                    
                }
            }
            // 보너스            
            else if(c=='S'||c=='D'||c=='T'){
                int num = Integer.parseInt(snum);
                System.out.println(num);
                if(c=='S'){
                    game[idx]=(int)Math.pow(num, 1);
                }else if(c=='D'){
                    game[idx]=(int)Math.pow(num, 2);
                }else{
                    game[idx]=(int)Math.pow(num, 3);
                }
            }
            //옵션
            else{
                if(c=='*'){
                    if(idx>=1) game[idx-1]*=2;
                    game[idx]*=2;
                }
                else{
                    game[idx]*=-1;
                }
                
            }
        }
        answer = game[0]+game[1]+game[2];
        return answer;
    }
}