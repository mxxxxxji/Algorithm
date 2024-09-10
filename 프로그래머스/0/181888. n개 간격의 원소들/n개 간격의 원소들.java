class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[((num_list.length-1)/n)+1];
        int idx=0;
        int i=0;
        while(idx<num_list.length){
            answer[i] = num_list[idx];
            idx += n;
            i+=1;
        }
        return answer;
    }
}