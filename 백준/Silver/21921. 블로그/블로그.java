import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, X;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }

        int sum = 0;
        int start = 0;
        int end = start+ X;
        for(int i=start; i<end; i++){
            sum += arr[i];
        }
        int max = sum;
        int cnt = 1;
        while(end<N){

            sum-= arr[start];
            sum += arr[end];
            if(max == sum) {
                cnt++;
            }
            if(max < sum) {
                cnt = 1;
                max = sum;
            }

            start+=1;
            end+=1;
        }

        if(max!=0) {
            System.out.println(max);
            System.out.println(cnt);
        } else System.out.println("SAD");

    }
}