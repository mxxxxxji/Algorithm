import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Main {

	public static int[][] c;
	public static int N;
	public static int result;
	public static void DFS(int idx, int pay) {
		if(idx>=N) {
			result = Math.max(result, pay);
			return;
		}
		if(idx + c[idx][0] <= N) {
			DFS(idx + c[idx][0], pay + c[idx][1]);
		}else {
			DFS(idx + c[idx][0], pay);
		}
		DFS(idx+1, pay);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		N = Integer.parseInt(br.readLine());
		c = new int[N][2];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			c[i][0] = Integer.parseInt(s[0]);
			c[i][1] = Integer.parseInt(s[1]);
		}
		

		result=0;
		DFS(0,0);
		System.out.println(result);
	}

}