class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        int idx = 0;
        while(idx<num_list.length){
            if(n>=num_list.length) n=0;
            answer[idx] = num_list[n];
            n+=1;
            idx+=1;
        }
        return answer;
    }
}