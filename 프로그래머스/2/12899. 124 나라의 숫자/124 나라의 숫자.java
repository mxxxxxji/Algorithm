class Solution {
    
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] number = {1, 2, 4};
        if(n==1) return "1";
        else if(n==2) return "2";
        else if(n==3) return "4";
        else{
            while(true){
                if(n<=0) break;
                if(n>3){
                    if(n%3==0){     
                        sb.insert(0, "4");
                        n=n/3-1;
                    }else{
                        sb.insert(0, number[n%3-1]);
                        n=n/3;
                    }
                }else{
                    sb.insert(0, number[n-1]);
                    break;
                }
            }
        }
        
        return sb.toString();
    }
   
}