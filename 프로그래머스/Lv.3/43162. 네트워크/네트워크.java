class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                answer++;
                dfs(n, computers, i);
            }
        }
        return answer;
    }
    static void dfs(int n, int[][] computers, int cur){
        for(int i=0; i<n; i++){
            if(!visited[i]&&computers[cur][i]==1){
                visited[i] = true;
                dfs(n, computers, i);
            }
        }
        
    }
}