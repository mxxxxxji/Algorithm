import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static String input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int start, end, mid;
        for(int i=0; i<T; i++){
            input = br.readLine();

            start = 0;
            end = input.length()-1;
            boolean result = check(start, end);
            if(result) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }
    private static boolean check (int start, int end){
        if(start==end) return true;

        int mid = (start + end) / 2;
        for(int i=start; i<mid; i++) {
            if (input.charAt(i) == input.charAt(end - i)) return false;
        }

        return check(mid +1, end) && check(start, mid-1);
    }
}