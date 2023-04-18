class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb=new StringBuilder();
        int[] numX = new int[10];
        int[] numY = new int[10];
        for(int i=0; i<X.length(); i++){
            numX[X.charAt(i)-'0']++;
        }
        for(int i=0; i<Y.length(); i++){
            numY[Y.charAt(i)-'0']++;
        }
        for(int i=9; i>=0; i--){
            while(numX[i]>0 && numY[i]>0){
                numX[i]--;
                numY[i]--;
                sb.append(i);
            }
        }
        String answer = "";
        if("".equals(sb.toString())){
            answer = "-1";
        }else if("0".equals(sb.toString().substring(0,1))){
            answer = "0";
        }else {
            answer = sb.toString();
        }
        return answer;
    }
}