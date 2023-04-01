import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 시험장의 개수
    static int[] A; // 각 시험장의 응시자 수
    static int B; // 총감독관이 감시할 응시자 수
    static int C; // 부감독관이 감시할 응시자 수
    static long count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 총감독관 각 1명
        count += N;
        for(int i=0; i<N; i++){
            A[i] -= B;
            if(A[i]>0){
                count += A[i]/C;
                if(A[i]%C!=0) count++;
            }
        }
        System.out.println(count);
    }
}