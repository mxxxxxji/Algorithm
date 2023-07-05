class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int idx = discount.length-1;
        int[] check;
        while(idx-9>=0){
            
            check = new int[number.length];
            for(int i=idx-9; i<=idx; i++){
                for(int j=0; j<want.length; j++){
                    if(want[j].equals(discount[i])) check[j]++;
                }
            }
            int flag = 0;
            for(int i=0; i<number.length; i++){
                if(number[i]!=check[i]){
                    flag=1; break;
                }
            }
            if(flag==0) {
                answer++;
            }
            idx--;
        }
        return answer;
    }
}