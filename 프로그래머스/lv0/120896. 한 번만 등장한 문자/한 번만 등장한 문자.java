class Solution {
    public String solution(String s) {
        String answer = "";
        int[] a = new int[26];
        
        for(int i=0; i<s.length(); i++){
            a[s.charAt(i)-97]++;
        }
        
        for(int i=0; i<a.length; i++){
            if(a[i]==1){
                answer+=String.valueOf((char)(97+i));
            }    
        }
        return answer;
    }
}