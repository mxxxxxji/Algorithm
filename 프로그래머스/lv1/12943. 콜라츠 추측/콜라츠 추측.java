class Solution {
    public int solution(int num) {
        int answer = 0;
        long tmp = (long)num;
        while(true){
            if(answer==500 || tmp==1) break;
            if(tmp%2==0){
                tmp=tmp/2;
                answer++;
            }else{
                tmp*=3;
                tmp++;
                answer++;
            }
        }
        if(answer>=500 && tmp!=1) answer=-1;
        return answer;
    }
}