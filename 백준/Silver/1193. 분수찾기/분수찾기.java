import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int i = 0;
        int st = 1;
        while(true){
            if(n<=st+i){
                if((i+1)%2==0){ //짝수 정방향 1/2-2/1
                    System.out.println((n-st+1)+"/"+(i-(n-st-1)));
                }else{ // 홀수 반대방향으로 3/1-2/2-1/3
                    System.out.println((i-(n-st-1))+"/"+(n-st+1));
                }
                break;
            }else{
                i+=1;
                st = st+i;
            }
        }
    }
}