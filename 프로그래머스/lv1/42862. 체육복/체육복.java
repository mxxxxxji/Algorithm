class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] a = new int[n];
        
        for(int i=0; i<lost.length; i++){
            a[lost[i]-1]--;  
        }
        for(int i=0; i<reserve.length; i++){
            a[reserve[i]-1]++;
        }
       
        for(int i=0; i<a.length; i++){
            int r = i+1;
            int l = i-1;
  
            if(l>=0 && a[l]==-1 && a[i]==1){
                a[i]--;
                a[l]++;
            }
            if(r<a.length && a[r]==-1 && a[i]==1){
                a[i]--;
                a[r]++;
            }

        }
        
         
        for(int i=0; i<a.length; i++){
            if(a[i]>=0) answer++;
        }
        return answer;
    }
}