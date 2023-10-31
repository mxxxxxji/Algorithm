import java.util.*;
class Solution {
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static boolean[][] visited;
    public int[] solution(String[] maps) {
        
        ArrayList<Integer> list = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(visited[i][j]||maps[i].charAt(j)=='X') continue;
                int res = bfs(i, j, maps);
                if(res!=0) list.add(res);
            }
        }
        int[] answer;
        if(list.size()==0) {
            answer = new int[1];
            answer[0] = -1;
        }else{
            Collections.sort(list);
            answer = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
    static int bfs(int y, int x, String[] maps){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        int sum = maps[y].charAt(x)-'0';
        while(!q.isEmpty()){
            int[] p = q.poll();
            int r = p[0]; int c = p[1];
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                
                if(nr<0 || nc<0 || nr>maps.length-1 || nc>maps[0].length()-1) continue;
                if(visited[nr][nc]) continue;
                if(maps[nr].charAt(nc) == 'X') continue;
                
                sum += maps[nr].charAt(nc) -'0';
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
        return sum;
    }
}