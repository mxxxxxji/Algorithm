class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        // 시작 위치 좌표
        int sy =0;
        int sx =0;
        
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j)=='S') {
                    sy = i; sx =j;
                }
            }
        }
        

        
        for(int i=0; i<routes.length; i++){
            char d = routes[i].charAt(0);
            int n = routes[i].charAt(2)-'0';
            System.out.println("d, n : "+d + ", "+ n);
            int ny= sy;
            int nx= sx;
            for(int j=0; j<n; j++){
                if(d=='E'){
                    nx++;
                }else if(d=='W'){
                    nx--;
                }else if(d=='S'){
                    ny++;
                }else{
                    ny--;
                }
                if(ny>=0 && nx>=0 && ny<park.length && nx<park[0].length()){
                    if(park[ny].charAt(nx)=='X') break;
                    if(j == n-1){
                        sy = ny;
                        sx = nx;
                    }
                    
                }
                
                
            }
          System.out.println(sy + ", " + sx);
        }
        answer[0] = sy;
        answer[1] = sx;
        return answer;
    }
}