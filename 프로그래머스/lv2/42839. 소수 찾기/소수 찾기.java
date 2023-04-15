import java.util.*;
class Solution {
    static String[] number;
    static boolean[] visited;
    static String[] out;
    //static ArrayList<Integer> list = new ArrayList<>();
    static Set<Integer> set = new HashSet();
    public int solution(String numbers) {
        int answer = 0;
        number = numbers.split("");

        out = new String[number.length];
        visited = new boolean[number.length];
     
        // 자리수
        for(int i=1; i<=number.length; i++){
            permutation(0, i);
        }
    
        //answer = list.size();
        answer =set.size();
        return answer;
    }

    static void permutation(int depth, int r){
        if(depth==r){
            String s = "";
        
            for(int i=0; i<r; i++){
                s+=out[i];
            }
            // 같은 수 포함되어 있지 않다면 && 소수인 경우
            // if(!list.contains(Integer.parseInt(s)) && isPrime(Integer.parseInt(s))){
            //     list.add(Integer.parseInt(s));
            // }
            if(isPrime(Integer.parseInt(s))){
                set.add(Integer.parseInt(s));
            }
    
            return;
        }
        
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = number[i];
                permutation(depth+1, r);
                visited[i] = false;
            }
        }
    }
    public static boolean isPrime(int num){
        boolean isPrime = true;
        if(num<=1) isPrime = false;
        if(num>1){
            for(int i = 2; i<num; i++){
                if(num%i==0){
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }
    
}