class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int cnt_zero = 0;
        while(!s.equals("1")){
            int len = s.length();
            s = s.replace("0","");
            int n = s.length();
          
            cnt_zero += len - n;
            cnt++;
            s = Integer.toBinaryString(n);
        }
        answer[0] = cnt;
        answer[1] = cnt_zero;
        return answer;
    }
}