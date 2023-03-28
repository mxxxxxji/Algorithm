import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        if(arr.length <= 1){
            list.add(-1);
        }else{
            
            for(int i=0; i<arr.length; i++){
                pq.offer(arr[i]);
            }
            int min = pq.poll();
            
            for(int j=0; j<arr.length; j++){
                if(arr[j]!=min) list.add(arr[j]);
            }
           
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}