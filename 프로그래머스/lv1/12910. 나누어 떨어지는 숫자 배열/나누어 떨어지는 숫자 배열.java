import java.util.PriorityQueue;
class Solution {
    public int[] solution(int[] arr, int divisor) {
       
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0) pq.offer(arr[i]);
        }
        int[] answer;
        int idx=0;
        if(pq.isEmpty()){
            answer = new int[1];
            answer[0]=-1;
        }else{
            answer = new int[pq.size()];
            while(!pq.isEmpty()){
                answer[idx] = pq.poll();
                idx++;
            }
        }
        
        return answer;
    }
}