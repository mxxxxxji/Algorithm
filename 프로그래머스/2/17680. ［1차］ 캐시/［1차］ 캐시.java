import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // 캐시 크기가 0일 경우
        if(cacheSize==0){
            return cities.length*5;           
        }
        List<String> list = new LinkedList<>();
        for(int i=0; i<cities.length; i++){
            // 대소문자 구분x                  
            String city = cities[i].toLowerCase();
            
            // cache miss
            if(!list.contains(city)){
                answer += 5;
                if(cacheSize <= list.size()){
                    list.remove(0);
                }
                list.add(city);
            } else { // cache hit
                answer += 1;
                list.remove(city);
                list.add(city);
                
            }
        }
        return answer;
    }
}