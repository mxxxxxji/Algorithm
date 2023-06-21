import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> gem_type = new HashSet<>();
        
        for(String gem: gems){
            gem_type.add(gem);
        }
        
        Map<String, Integer> map = new HashMap<>();
        int s = 0;
        int e = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<gems.length; i++){
            e=i;
            map.put(gems[e], map.getOrDefault(gems[e],0) + 1);
            
            while(map.get(gems[s])>1){
                map.put(gems[s], map.get(gems[s])-1);
                s++;
            }
            
            if(map.size()==gem_type.size()&&e-s<min){
                min = e-s;
                answer[0] = s+1;
                answer[1] = e+1;
            }
        }
        return answer;
    }
}