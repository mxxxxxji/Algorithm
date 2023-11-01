class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int cupon = chicken;
        while(cupon>9){
            //System.out.println(answer+"마리, "+cupon+"장");
            answer+=cupon/10;
            cupon = cupon/10 + cupon%10; 
        }
        return answer;
    }
}