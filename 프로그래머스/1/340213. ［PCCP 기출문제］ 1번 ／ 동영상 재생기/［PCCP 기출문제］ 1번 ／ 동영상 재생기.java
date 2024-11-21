import java.util.*;
import java.time.*;
class Solution {
    // 동영상 길이, 기능 수행 전 재생위치, 오프닝 시작 시각, 끝나는 시각, 사용자의 입력
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int len = stringTotime(video_len);
        int time = stringTotime(pos);
        int op_s = stringTotime(op_start);
        int op_e = stringTotime(op_end);
        
        // 오프닝 구간일 경우
        time = skip(time, op_s, op_e);
        
        for(int i=0; i<commands.length; i++){
            String cmd = commands[i];
            if("prev".equals(cmd)){
                time = Math.max(time-10, 0);
            }else{
                time = Math.min(time+10, len);
            }
            // 이동한 후 오프닝 구간일 경우
            time = skip(time, op_s, op_e);
        }
        return timeTostring(time);
    }
    static int stringTotime(String s){
        String[] str = s.split(":");
        int m = Integer.parseInt(str[0]);
        int ss = Integer.parseInt(str[1]);
        return m*60 + ss;
    }
    static String timeTostring(int t){
        int m = t/60;
        int s = t%60;
        return String.format("%02d:%02d", m, s);
    }

    static int skip(int time, int op_s, int op_e){
        // 오프닝 구간일 경우 오프닝 끝나는 위치로 이동
        if (time >= op_s && time <= op_e) {
            return op_e;
        }
        return time;
    }
}