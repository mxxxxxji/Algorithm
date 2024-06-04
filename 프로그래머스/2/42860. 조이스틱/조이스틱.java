class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() -1; // 쭉 가는 경우
        for(int i=0; i<name.length(); i++){
            // 상하로 움직여 알파벳 맞추기 
            // (위, 아래)
            answer += Math.min(26 - name.charAt(i) + 'A', name.charAt(i) - 'A');
            // 연속된 A가 있는 경우
            if(i<name.length()-1 && name.charAt(i+1)=='A'){
                int endA = i+1;
                while(endA<name.length() && name.charAt(endA) == 'A'){
                    endA++;
                }
                // 왼쪽으로 갔다가 오른쪽으로 돌아오는 경우
                move = Math.min(move, (name.length()-endA)*2 + i);
                // 오른쪽으로 가다가 왼쪽으로 돌아오는 경우
                move = Math.min(move, i*2 + name.length()-endA);
            }
        }
        return answer + move;
    }
}