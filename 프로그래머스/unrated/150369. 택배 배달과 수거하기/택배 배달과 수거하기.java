class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // 1. 배달할 상자와 수거할 상자의 합을 구한다
        int dSum = 0;
        int pSum = 0;
        for(int i=0; i<deliveries.length; i++){
            dSum += deliveries[i];
        }
        for(int i=0; i<pickups.length; i++){
            pSum += pickups[i];
        }
        
        
        int idx = n-1;
        
        while(dSum!=0 || pSum!=0){
            while(deliveries[idx]==0 && pickups[idx]==0){
                idx-=1;  
            }
            int dIdx = idx;
            int pIdx = idx;
            int dcap = cap;
            int pcap = cap;
            // 배달
            while(dcap>0 && dIdx>=0 &&dSum!=0){
                if(deliveries[dIdx]<=dcap){
                    dcap -= deliveries[dIdx];
                    dSum -= deliveries[dIdx];
                    deliveries[dIdx] = 0;
                }else{
                    deliveries[dIdx] -= dcap;
                    dSum -= dcap;
                    dcap = 0;
                }
                dIdx-=1;
            }
            // 픽업
            while(pcap>0 && pIdx>=0 &&pSum!=0){
                if(pickups[pIdx]<=pcap){
                    pcap -= pickups[pIdx];
                    pSum -= pickups[pIdx];
                    pickups[pIdx] = 0;
                }else{
                    pickups[pIdx] -= pcap;
                    pSum -= pcap;
                    pcap = 0;
                }
                pIdx-=1;
            }
            answer += (idx+1)*2;
        }
        
        return answer;
    }
}