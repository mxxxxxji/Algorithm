import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];
        boolean flag = true;
        
        for(int i=0; i<num.length; i++){
            num[i] = String.valueOf(numbers[i]);
            if(numbers[i] != 0) flag = false;
        }
        
        Arrays.sort(num, new Comparator<String>(){
           @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
        
        for(int i=0; i<numbers.length; i++){
            answer+=num[i];
        }
        if(flag) answer = "0";
        return answer;
    }
}