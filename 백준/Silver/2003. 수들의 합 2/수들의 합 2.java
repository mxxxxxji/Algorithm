import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start=0;
        int end=0;
        int sum = 0;
        int count = 0;
        while(true){
            if(sum>=M){
                sum-=arr[start];
                start++;
            }else if(end==N){
                break;
            }else{
                sum+=arr[end];
                end++;
            }
            if(sum==M) count++;
        }
        System.out.println(count);
    }
}