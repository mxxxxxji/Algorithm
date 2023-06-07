class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 1;
        long end = 0;
        long mid = 0;
        for(int i=0; i<times.length; i++){
            end = Math.max(times[i], end);
        }
        
        answer = end*n;
        while(start<=end){
            mid = (start+end)/2;
            long count = 0;
            for(int i=0; i<times.length; i++){
                count += mid/times[i];
            }
        
            if(count<n){
                start = mid +1;
                 answer= mid;
            }else{
                end = mid -1;
               
            }
        }
       // answer = (end+start)/2;
        
        return answer;
    }
}