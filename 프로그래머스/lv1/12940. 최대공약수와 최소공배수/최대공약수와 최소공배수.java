class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        // 더 큰 수
        int b = Math.max(n, m);
        int s = Math.min(n, m);
        
        // 최대공약수(유클리드호제법)
        int r;
        while(s>0){
            r = b%s;
            b = s;
            s = r;
        }
        answer[0] = b;
        
        //최소공배수
        answer[1] = n*m/b;
        
        return answer;
    }
}