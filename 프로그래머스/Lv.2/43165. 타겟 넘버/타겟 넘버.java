class Solution {
    static int answer; 
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    private static void dfs(int depth, int sum, int[] numbers, int target){
        if(depth == numbers.length){
            if(sum == target) answer++;
            return;
        }
        dfs(depth+1, sum+numbers[depth], numbers, target);
        dfs(depth+1, sum-numbers[depth], numbers, target);
    }
}