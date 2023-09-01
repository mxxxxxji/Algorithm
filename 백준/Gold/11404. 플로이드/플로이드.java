import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// Integer.MAX_VALUE 사용시 
	// Integer.MAX_VALUE + 비용의 경우 스택오버플로우 발생
	// 
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] track = new int[n+1][n+1];
	
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(track[i], INF);
			track[i][i] = 0;
		}

		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			track[start][end] = Math.min(track[start][end], value);
			
		}
//		for(int i=1; i<=n; i++) {
//			for(int j=1; j<=n; j++) {
//				System.out.print(track[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
	
		for(int i=1; i<=n; i++) {
			// if(a->b > a->c + a->b)
			for(int j=1; j<=n; j++) {
				for(int k=1; k<=n; k++) {
//					if(track[j][i] != Integer.MAX_VALUE && track[i][k] != Integer.MAX_VALUE) {
//						track[j][k] = Math.min(track[j][k], track[j][i] + track[i][k]);
						if(track[j][k] > track[j][i] + track[i][k]) {
							track[j][k] = track[j][i] + track[i][k];
						}
//					}
					
				}
				
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(track[i][j] == INF) {
					track[i][j] = 0;
				}
				//System.out.print(track[i][j]+" ");
				sb.append(track[i][j]+" ");
			}
			//System.out.println();
			sb.append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}