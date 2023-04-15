import java.util.*;
class Solution {
    static ArrayList<Integer> resultList = new ArrayList<>();
    
    public static void main(String args[]){
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
    
    public static int solution(String numbers) {
      
        int len = numbers.length();
        int[] arr = new int[len];
        
        for(int i=0; i<len; i++) arr[i] = numbers.charAt(i) - '0';

        for(int i=1; i<=len; i++) permutation(arr, 0, len, i);
        
        return resultList.size();
    }

    public static void permutation(int[] arr, int depth, int n, int r) {
      
        if(depth == r) {
            String number = "";
            for(int i=0; i<r; i++) {
                number += arr[i];
            }

            if(isPrime(Integer.valueOf(number)) && !resultList.contains(Integer.valueOf(number)) ) {
                resultList.add(Integer.valueOf(number));
            }

            return;
        }

        for(int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    public static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static boolean isPrime(int n){
        if(n<2) return false;

        for(int i=2; i<=(int) Math.sqrt(n); i++) {
            if(n%i == 0) {
               return false;
            }
        }

        return true;
    }
}