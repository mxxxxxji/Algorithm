class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int e = Math.max(a,b);
        int s = Math.min(a,b);
        for(int i=s; i<=e; i++){
            answer += (long)i;
        }
        return answer;
    }
}