import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            int v = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]==0) q.add(v);
            else q.add(v+1);
            
        }
        int cur = q.poll();
        int count = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        while(!q.isEmpty()){
            int p = q.poll();
            if(cur >= p) {
                count+=1;
            }else{
                System.out.println(p+", "+cur);
                arr.add(count);
                count=1;
                cur=p;
            }
        }
        arr.add(count);
        int[] answer = new int[arr.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}