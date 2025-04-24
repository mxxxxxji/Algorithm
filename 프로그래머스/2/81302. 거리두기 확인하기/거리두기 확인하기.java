class Solution {
    private static final int[][] dir = {{-1,0}, {0,-1}, {0,1}, {1,0}}; // 상, 좌, 우, 하
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++){
            String[] place = places[i];
            char[][] room = new char[place.length][];
            
            for(int j=0; j<place[i].length(); j++){
                room[j] = place[j].toCharArray();                    
            }
            
            if(isDistanced(room)) {
                answer[i]=1;
            }
        }
        return answer;
    }
    // 오버로딩 활용
    // 해당 대기실이 거리두기를 지켰는지 확인
    private boolean isDistanced(char[][] room){
        for(int i=0; i<room.length; i++){
            for(int j=0; j<room[0].length; j++){
                if(room[i][j] != 'P') continue;
                if(!isDistanced(i, j, room)) return false;
            }
        }
        return true;
    }
    // 오버로딩 활용
    // 해당 대기실의 해당 위치(y, x)의 응시자가 거리두기를 지켰는지 확인
    private boolean isDistanced(int y, int x, char[][] room){
        //거리두기 검사
        for(int d=0; d<4; d++){
            int dy = y + dir[d][0];
            int dx = x + dir[d][1];
            if(dy<0 || dx<0 || dy >= room.length || dx >= room[dy].length) continue;
            switch(room[dy][dx]){
                case 'P': return false;
                case 'O': 
                    // 다음 검사할 위치의 반대 방향 =  현재 검사할 지원자의 위치 = 3-d
                    if(isNextToVolunteer(dy, dx, room, 3-d)) return false;
                    break;
            }
        }                                         
        return true;
    }
    private boolean isNextToVolunteer(int y, int x, char[][] room, int exclude){
        for(int d=0; d<4; d++){
            // 기존의 지원자는 제외
            if(d == exclude) continue;
            int dy = y + dir[d][0];
            int dx = x + dir[d][1];
            
            if(dy<0 || dx<0 || dy>=room.length || dx>= room[dy].length) continue;
            if(room[dy][dx] == 'P') return true;
        }
        return false;
    }
}