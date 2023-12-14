import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Time[] times;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times= new Time[N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times[i] = new Time(s, e);
        }
        Arrays.sort(times);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(times[0].end);
        for (int i = 1; i < N; i++) {
            if (!pq.isEmpty() && pq.peek() <= times[i].start) {
                pq.poll();
            }
            pq.add(times[i].end);
        }

        System.out.println(pq.size());
    }
    static class Time implements Comparable<Time>{
        int start;
        int end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Time t){
            if(start==t.end){
                return end-t.end;
            }
            return start-t.start;
        }
    }
}