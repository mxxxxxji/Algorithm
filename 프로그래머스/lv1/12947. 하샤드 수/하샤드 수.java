class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String s = String.valueOf(x);
        char[] c = s.toCharArray();
        int sum = 0;
        for(int i=0; i<c.length; i++){
            sum += Integer.parseInt(c[i]+"");
        }
        if(x%sum!=0) answer = false;
        return answer;
    }
}