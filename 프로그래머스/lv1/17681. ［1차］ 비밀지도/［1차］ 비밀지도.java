import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for(int i=0; i<arr1.length; i++){
            String s = Integer.toBinaryString(arr1[i]);
            String s2 = Integer.toBinaryString(arr2[i]);
            //System.out.println(s);
            if(s.length()<n){
                // System.out.println(s.length());
                String add = "";
                for(int j=0; j<n-s.length(); j++){
                    add+="0";
                }
                s = add+s;
               // System.out.println(add);
                      
            }
            if(s2.length()<n){
                // System.out.println(s.length());
                String add = "";
                for(int j=0; j<n-s2.length(); j++){
                    add+="0";
                }
                s2 = add+s2;
               // System.out.println(add);
                      
            }
            //System.out.println(s);
             String res = "";
            for(int j=0; j<s.length(); j++){
               // System.out.println(s.charAt(j));
               
                if(s.charAt(j)=='1'||s2.charAt(j)=='1') res += "#";
                else res += " ";
                //System.out.println(res);
            }
            answer[i] = res;
        }
        return answer;
    }
}