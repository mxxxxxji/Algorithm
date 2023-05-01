import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] out;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		out = new int[M];
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		rec(0,0);
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
		for(int i=start; i<N; i++){
			out[depth] = arr[i];
			rec(depth+1, i+1);
		}
	}

}