import java.util.*;
class Solution {
    static ArrayList<Integer>[] list;
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        list = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[i].length; j++){
                if(computers[i][j]==1){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                DFS(i);
                answer++;
            }
        }
        return answer;
    }
    static void DFS(int com){
        visited[com] = true;
        for(int i=0; i<list[com].size(); i++) {
            if(!visited[list[com].get(i)]) {
                visited[list[com].get(i)] = true;
                DFS(list[com].get(i));
            }
        }
    }
}