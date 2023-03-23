import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] res;
	static void recursion(int depth, int start) {
		if(depth == M) {
			for(int i=0; i<res.length; i++) {
				System.out.print(res[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<=N; i++){
			res[depth] = i; 
			recursion(depth+1, i+1);
		}
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = new int[M];
		recursion(0, 1);
	}

}