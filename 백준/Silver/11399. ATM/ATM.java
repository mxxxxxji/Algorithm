import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] P;
	static int result;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		P = new int[N];
		for(int i=0; i<N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(P);
		
		for(int i=0; i<N; i++) {
			result += P[i]*(N-i);
		}
		
		System.out.println(result);
	}

}