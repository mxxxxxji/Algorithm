class Solution {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, target, 0, 0);
        return count;
    }
    static void dfs(int[] numbers, int target, int depth, int sum){
        if(depth == numbers.length){
            if(target == sum) count++;
            return;
        }
        dfs(numbers, target, depth+1, sum + numbers[depth]);
        dfs(numbers, target, depth+1, sum - numbers[depth]);
    }
}