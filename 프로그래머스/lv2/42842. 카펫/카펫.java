class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int nm = (brown-4)/2;
        for(int i=1; i<=nm/2; i++){
            int h = nm-i;
            int w = i;
            if(h*w==yellow){
                answer[0] = h+2;
                answer[1] = w+2;
            }
        }
        return answer;
    }
}