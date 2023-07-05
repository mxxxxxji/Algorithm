class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        int idx=0;
        for(long i=left; i<=right; i++){
            if(i/n<i%n) answer[idx] = (int)(i%n) + 1;
            else answer[idx] = (int)(i/n) + 1;
            idx++;
        }
        return answer;
    }
}