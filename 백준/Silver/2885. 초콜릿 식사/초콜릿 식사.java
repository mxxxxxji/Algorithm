import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = 1;
        int cnt = 0;
        while(true){
            if(n>=K) break;
            n*=2;
        }
        // 최소 초콜릿의 크기
        sb.append(n).append(" ");

        while(K>0){
            // 최소 초콜릿이 더 크면 쪼개기
            if(K<n){
                n/=2;
                cnt++;
            }else{ // 더 작으면 안쪼개도 되니까 필요한 양(K)에서 뻬기
                K-= n;
            }
        }
        sb.append(cnt).append('\n');
        System.out.println(sb);
    }

}