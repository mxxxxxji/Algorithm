import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
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
        Arrays.sort(arr);
        int[] answer = new int[2];
        int start = 0;
        int end = arr.length-1;
        int min = Integer.MAX_VALUE;
        while(start<end){
            int sum = arr[start]+arr[end];
            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = arr[start];
                answer[1] = arr[end];
            }else{
                if(sum<0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        System.out.println(answer[0] +" " + answer[1]);

    }
}