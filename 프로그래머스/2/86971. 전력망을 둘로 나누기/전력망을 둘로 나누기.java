import java.util.*;
class Solution {
    static int map[][];

    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n+1][n+1];
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = 1;
            map[b][a] = 1;
        }
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = 0;
            map[b][a] = 0;
           
      
            answer = Math.min(answer, bfs(i+1, n));
            
            map[a][b] = 1;
            map[b][a] = 1;
        }
        return answer;
    }
    public static int bfs(int x, int n){
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n+1];
        q.add(x);
        visited[x] = 1;
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i=1; i<=n; i++){
                if(visited[i]==0 &&map[p][i]==1){
                    q.add(i);
                    count++;
                    visited[i]=1;
                }
            }
        }
        return (int)Math.abs(n-count*2);
    }
}