import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] res;
	static boolean[] visited;
	static void permutation(int k) {
		
		if(k==M) {
			for(int i=0; i<M; i++) {
				System.out.print(res[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				res[k] = i;
				permutation(k+1);
				visited[i] = false;
			}
		}
		
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		res = new int[M+1];
		visited = new boolean[N+1];
		
		permutation(0);
	}
}