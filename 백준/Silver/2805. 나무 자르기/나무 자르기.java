import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; //나무의 수
	static long M; //가져갈 나무의 길이
	static long[] wood;
	static long start, end, mid;
	static long result;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		wood = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			wood[i] = Long.parseLong(st.nextToken());
			end = Math.max(wood[i], end);
		}
		
		start = 0;
		result = 0;
		
		while(start<=end) {
			mid = (start+end)/2;
			long len = 0;
			for(int i=0; i<N; i++) {
				if(wood[i]-mid>0) len += (wood[i]-mid); 
			}
			
			
			if(len<M) {
				end = mid -1;
			}else {
				start = mid + 1;
			}
		}
		
		result = (start+end)/2;
		
		System.out.print(result);
	}
}