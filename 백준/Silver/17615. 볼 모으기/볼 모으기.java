import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int result = Integer.MAX_VALUE;
        int blueCnt = 0;
        int redCnt = 0;
        for(int i=0; i<N; i++){
            if(s.charAt(i)=='R') redCnt++;
            else blueCnt++;
        }


        int cnt = 0;
        // 파란 공을 왼쪽에 모을 경우
        for(int i=0; i<N; i++){
            if(s.charAt(i)=='B') cnt++;
            else break;
        }
        result = Math.min(blueCnt-cnt, result);

        // 파란 공을 오른쪽에 모을 경우
        cnt = 0;
        for(int i=N-1; i>=0; i--){
            if(s.charAt(i)=='B') cnt++;
            else break;
        }
        result = Math.min(blueCnt-cnt, result);

        // 빨간 공을 왼쪽에 모을 경우
        cnt = 0;
        for(int i=0; i<N; i++){
            if(s.charAt(i)=='R') cnt++;
            else break;
        }
        result = Math.min(redCnt-cnt, result);

        // 빨간 공을 오른쪽에 모을 경우
        cnt = 0;
        for(int i=N-1; i>=0; i--){
            if(s.charAt(i)=='R') cnt++;
            else break;
        }
        result = Math.min(redCnt-cnt, result);

        System.out.println(result);
    }
}