class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int cnt = 1;
            while(cnt<=index){
                c+=1;
                if(c>'z') c-=26;
                if(skip.indexOf(c+"")!=-1) continue;
                else cnt++;
            }
            answer+=c;
        }
        
        return answer;
    }
}