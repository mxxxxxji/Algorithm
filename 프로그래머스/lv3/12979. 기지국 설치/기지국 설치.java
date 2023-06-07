class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        int idx = 0; // 기지국이 설치된 곳의 인덱스
        while(position<=n){
            // 기지국의 전파가 닿는 곳이라면
            if(idx < stations.length && position>=stations[idx]-w){
                // 그 기지국의 전파 범위 뛰어 넘기
                position = stations[idx] + w + 1;
                idx++;
            }else{
                answer+=1; // 기지국 추가
                position += (w*2) +1;
            }
        }

        return answer;
    }
}