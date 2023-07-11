import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq;
    static Integer[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer A, Integer B){
                if(A<B) return 1;
                else return -1;
            }
        });
       
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0; i<N-1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());

    }
}