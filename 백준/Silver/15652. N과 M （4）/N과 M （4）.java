import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] out;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		out = new int[M];
		rec(0, 1);
		System.out.print(sb);
	}
	public static void rec(int depth, int start) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(out[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=start; i<=N; i++) {
	
			out[depth] = i;
			rec(depth+1, i);
		}
	}
}