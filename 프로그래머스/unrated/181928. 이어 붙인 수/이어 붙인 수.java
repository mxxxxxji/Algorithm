class Solution {
    public int solution(int[] num_list) {
        
        String a = "";
        String b = "";
        for(int i=0; i<num_list.length; i++){
            if(num_list[i]%2==0){
                a += String.valueOf(num_list[i]);
            }else{
                b += String.valueOf(num_list[i]);
            }
        }
        int answer = Integer.parseInt(a)+Integer.parseInt(b);
        return answer;
    }
}