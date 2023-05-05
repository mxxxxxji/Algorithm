class Solution {
    public String solution(String s) {
        String answer = "";
//        s = s.toLowerCase();
        String[] arr = s.split(" ");
        
        for(int i=0; i<arr.length; i++){
            if(arr[i].length()==0){
                answer+=" ";
            }else{
//                 if('a'<=arr[i].charAt(0) && arr[i].charAt(0)<='z'){
//                     char c = (char)(arr[i].charAt(0)-32);

//                     arr[i] = arr[i].replace(String.valueOf(arr[i].charAt(0)), String.valueOf(c));

//                 } 
//                 answer +=arr[i]+" ";
                String str = arr[i];
                answer+= str.substring(0,1).toUpperCase();
                answer+= str.substring(1,str.length()).toLowerCase();
                answer+=" ";
            }


        }
        
        if(s.substring(s.length()-1, s.length()).equals(" ")) return answer;
        else return answer.substring(0, answer.length()-1);
        

    }
}