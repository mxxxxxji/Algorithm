import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Time[] book_arr = new Time[book_time.length];
        // 0. 분으로 변경
        for(int i=0; i<book_time.length; i++){
            String[] str = book_time[i][0].split(":");
            int start = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
            
            String[] str2 = book_time[i][1].split(":");
            int end = Integer.parseInt(str2[0])*60 + Integer.parseInt(str2[1]);
            
            book_arr[i] = new Time(start, end);
        }
        
        // 1. 입장시간 기준으로 정렬
        Arrays.sort(book_arr, new Comparator<Time>(){
            @Override
            public int compare(Time t1, Time t2){
                return t1.start - t2.start;
            }
        });

        // 2. 입장시간을 퇴장시장 list의 값들과 비교, 
            // 2-1. 입장시간>=퇴장시간, 퇴장시간+정리시간(10분) 변경
            // 2-2. 입장시간<퇴장시간, 방 개수 추가, 퇴장시간 추가

        // 방의 퇴실시간 저장
        // PQ로 해야하는 이유 : 가장 빠른 퇴실 시간 선택을 위해
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(book_arr[0].end+10);
        int idx = 1;
        answer = 1;
        while(pq.peek()!=1440 && idx<book_arr.length){
            int out = pq.poll();
            if(out>book_arr[idx].start) {
                pq.add(out);
                answer++;
            }
            pq.add(book_arr[idx].end+10);
            idx++;
            
        }
        
        return answer;
    }
    static class Time{
        int start;
        int end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}