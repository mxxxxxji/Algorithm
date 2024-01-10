import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int[] cnt = new int[100001];
        int answer = 0;
        while(end<arr.length){
            if(cnt[arr[end]]!=K){
                cnt[arr[end]]++;
                end++;
            }else{
                cnt[arr[start]]--;
                start++;
            }
            answer = Math.max(answer, end-start);
        }

        System.out.println(answer);

    }
}