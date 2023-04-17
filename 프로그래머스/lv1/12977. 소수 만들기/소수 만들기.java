class Solution {
    static int[] out;
    static int answer = 0;
    public int solution(int[] nums) {
        out = new int[3];
        combination(nums, 0,0);
        return answer;
    }
    
    public void combination(int[] nums, int depth, int start){
        if(depth==3){
            int sum = out[0]+out[1]+out[2];
            if(isPrime(sum)) answer++;
        }else{
            for(int i=start; i<nums.length; i++){
                out[depth] = nums[i];
                combination(nums,depth+1,i+1);
            }
        }
    }
    
    public boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}