import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr = {1, 2, 3};
    static boolean[] visited;
    static int[] res;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[3];
        res = new int[N];
        backtracking("");

    }
    private static void backtracking(String s){

        if(s.length()==N){
            System.out.println(s);
            System.exit(0);
        }
        for(int i=1; i<=3; i++){
            if(check(s+i)){
                backtracking(s+i);
            }
        }
    }
    static boolean check(String s){
        int len = s.length();
        for(int i=1; i<=len/2; i++){
            String front = s.substring(s.length()-i, s.length());
            String end = s.substring(s.length()-i-i, s.length()-i);
            //System.out.println(front+", "+end);
            if(front.equals(end)) {
                return false;
            }
        }
        return true;
    }
}