import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 각 유저는 한 번에 한 명의 유저만 신고 가능
        Map<String, HashSet<String>> reportMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        
        // 맵 초기화
        for(int i=0;i<id_list.length; i++){
            HashSet<String> hs = new HashSet<>();
            reportMap.put(id_list[i], hs);
            resultMap.put(id_list[i],0);
        }
        
        // 맵 세팅
        for(int i=0; i<report.length; i++){
            // 0:신고한, 1:신고당한
            String[] s = report[i].split(" ");
            reportMap.get(s[1]).add(s[0]);
        }
        
        // 정지 결과 맵 세팅
        for(String key : reportMap.keySet()){
            HashSet<String> reportedUser = reportMap.get(key);
            if(reportedUser.size()>=k){ // 신고된 횟수가 k이상일 경우
                for(String userId : reportedUser){
                    resultMap.put(userId, resultMap.get(userId)+1);
                }
            }
        }
        
        for(int i=0; i<answer.length; i++){
            answer[i] = resultMap.get(id_list[i]);
        }
        return answer;
    }
}