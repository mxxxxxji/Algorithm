import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, X;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int start = 0;
        int end = N-1;

        int count = 0;
        while(start<end){
            int sum = arr[start] + arr[end];
            if(sum==X) {
                count++;
                start++;
            }else if(sum<X){
                start++;
            }else{
                end--;
            }
        }
        System.out.println(count);
    }
}