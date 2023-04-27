class Solution {
    public int solution(int n) {
        int answer = 0;
        int n_count= change(n);
        int next = n;
        while(true){
            next+=1;
            int next_count = change(next);
            if(next_count==n_count) break;
         }
        answer = next;
        return answer;
    }
    static int change(int n){
        int count = 1;
        while(n>1){
            if(n%2==1) count++;
            n/=2;
        }
        return count;
    }
}