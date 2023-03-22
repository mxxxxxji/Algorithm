class Solution {
    public int solution(int a, int b, int n) {
        int answer = n/a*b;
        int rest = n%a;
        int cur = n/a*b + rest;
        
        while(cur>=a){
            answer += cur/a*b;
            rest = cur%a;
            cur = cur/a*b+rest;
        }
        return answer;
    }
}