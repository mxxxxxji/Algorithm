import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long M;
	static long[] cost;
	static long start, end, mid;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cost = new long[N];
		
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cost[i] = Long.parseLong(st.nextToken());
			end = Math.max(end, cost[i]);
		}
		
		M = Long.parseLong(br.readLine());
		
		start = 1;
		while(start<=end) {
			mid = (start + end)/2;
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(mid>cost[i]) sum += cost[i];
				else sum += mid;
			}
			
			if(sum<=M){
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		System.out.print((start+end)/2);
	}

}