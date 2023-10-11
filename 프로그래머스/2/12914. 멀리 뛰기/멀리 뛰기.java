class Solution {
    
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[n+2];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<n+1; i++){
            dp[i] = (dp[i-1] + dp[i-2])% 1234567;
        }
        answer = dp[n];
        return answer;
    }
    
    
}
// n=1 1
// 1
// n=2 2
// 1 1
// 2
// n=3 3
// 1 1 1
// 1 2
// 2 1
// n=4 5
// 1 1 1 1
// 1 1 2
// 1 2 1
// 2 1 1
// 2 2 
// n=5
//     n=4
// 1 1 1 1 1
// 1 1 1 2
// 1 1 2 1
// 1 2 1 1
// 1 2 2
//     n=3
// 2 1 1 1
// 2 1 2
// 2 2 1 

 
// f(n) + f(n-1)
    
    