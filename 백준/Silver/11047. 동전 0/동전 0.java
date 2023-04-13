import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int K;
	static int[] A;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=N-1; i>=0; i--) {
			if(K>=A[i]) {
				result += K/A[i];
				K = K%A[i];
			}
		}
		System.out.println(result);
	}

}