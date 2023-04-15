class Solution {
    static boolean[] visited;
    static int result;
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        dfs(k,dungeons, 0);

        return result;
    }
    public static void dfs(int hp, int[][] dungeons, int count){
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && dungeons[i][0]<=hp){
    
                visited[i]=true;
                dfs(hp-dungeons[i][1], dungeons, count+1);
                visited[i] = false;
            }
        }
        result = Math.max(result, count);
    }
}