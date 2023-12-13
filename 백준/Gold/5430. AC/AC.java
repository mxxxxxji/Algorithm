import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++) {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replace("[", "").replace("]","").split(",");

            sb.append(AC(cmd, n, arr));
            if(tc!=T-1) sb.append('\n');
        }
        System.out.println(sb);
    }
    static String AC(String op, int n, String[] arr) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            q.offer(Integer.parseInt(arr[i]));
        }
        boolean dir = true; // 방향 t:앞, f:뒤
        for(int i=0; i<op.length(); i++){
            char cmd = op.charAt(i);
            if(cmd=='R'){
                dir = !dir; // 방향 바꾸기
            }else{
                if(q.isEmpty()){
                    return "error";
                }
                if(dir){
                    q.pollFirst();
                }else{
                    q.pollLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(!q.isEmpty()) {
            if(dir){
                sb.append(q.pollFirst());
            }else{
                sb.append(q.pollLast());
            }
            if(!q.isEmpty()) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}