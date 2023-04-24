class Solution {
    // keymap : ["ABCE"] targets : ["ABDE"] 기댓값: -1
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for(int i=0; i<targets.length; i++){
        
            for(int j=0; j<targets[i].length(); j++){
                int min = 101; // 최소 인덱스
                String s = String.valueOf(targets[i].charAt(j));
                for(int k=0; k<keymap.length; k++){
                    if(keymap[k].indexOf(s)!=-1) {
                        if(min>keymap[k].indexOf(s)) {
                            min = keymap[k].indexOf(s);
                        }      
                    }
                }
                if(min!=101){
                     answer[i]=answer[i]+min+1;
                }else{
                    answer[i]=0; break;
                }

            }

        }
        for(int i=0; i<answer.length; i++){
            if(answer[i]==0) answer[i]=-1;
        }
        return answer;
    }
}