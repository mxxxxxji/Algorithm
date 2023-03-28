import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                if(o1.charAt(n)<o2.charAt(n)){ //오름차순
                    return -1;
                }else if(o1.charAt(n)>o2.charAt(n)){ //내림차순
                    return 1;
                }else if(o1.charAt(n)==o2.charAt(n)){
                    return o1.compareTo(o2); // 1이 작으면 -1, 2가 작으면 1
                }else{
                    return 0;
                }
            }
        });
        
         
        return strings;
    }
}