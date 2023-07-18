import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int dp[][], w[], v[];
	static ArrayList<int[]> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		w = new int[N+1];
		v = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken()); // 무게
			v[i] = Integer.parseInt(st.nextToken()); // 가치
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				dp[i][j] = dp[i-1][j];
				if(j-w[i]>=0) { //무게가 남거나 같으면
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]]+v[i]);
					
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}