class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String[] s = {"zero", "one", "two", "three","four","five", "six", "seven", "eight", "nine"};
        String res = "";
        int start_idx = 0;
        while(!"".equals(numbers)){
            String str;
            if(numbers.length()>=5){
                str = numbers.substring(start_idx, 5);
            }else{
                str = numbers;
            }
            
            System.out.println(str);
            for(int i=0; i<s.length; i++){
                int idx = str.indexOf(s[i]);
                if(idx!=-1){
                    String s1 = numbers.substring(0, idx);
                    String s2 = numbers.substring(idx+s[i].length(), numbers.length());
                    numbers = s1+s2;
                    res += i;
                }
            }
           
            
            
           
        }
        
        answer = Long.parseLong(res);
        return answer;
    }
}