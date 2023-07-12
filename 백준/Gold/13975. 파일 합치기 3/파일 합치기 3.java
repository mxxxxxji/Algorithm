import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int K;
    static PriorityQueue<Long> pq;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            pq = new PriorityQueue<>();
            st= new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++){
                Long num = Long.parseLong(st.nextToken());
                pq.add(num);
            }

            long answer = 0;
            long sum;
            while(pq.size()>1){
                long a = pq.poll();
                long b = pq.poll();
                sum = a+b;
                pq.add(sum);
                answer += sum;

            }
            System.out.println(answer);
        }

    }
}