class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int left = Integer.MAX_VALUE;
        int top = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MIN_VALUE;
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j)=='#'){
                    left=Math.min(left, j);
                    top=Math.min(top, i);
                    right=Math.max(right, j);
                    bottom=Math.max(bottom, i);
                }
            }
        }
        answer[0]=top;
        answer[1]=left;
        answer[2]=bottom+1;
        answer[3]=right+1;
        return answer;
    }
}