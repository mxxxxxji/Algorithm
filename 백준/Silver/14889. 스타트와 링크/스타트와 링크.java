import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr; // 능력치
	static int[] team;
	static boolean[] visited;
	static int[][] res;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr= new int[N][N];
		res = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		team = new int[N/2];
		visited = new boolean[N];
	
		com(0 , 0);
		System.out.println(min);
		
	}
	public static void com(int start, int depth) {
		if(depth==N/2) {
			diff();
			return;
		}
		for(int i=start; i<N; i++) {
			if(!visited[i]) {
				team[depth] = i;
				visited[i] = true;
				com(i + 1, depth+1);
				visited[i] = false;
			}
			
		}
	}
	public static void diff() {
		int start = 0;
		int link = 0;
		for(int i=0; i<N-1; i++) {
			for(int j=i; j<N; j++) {
				if(visited[i] && visited[j]) {
					start+=arr[i][j];
					start+=arr[j][i];
				}else if(!visited[i] && !visited[j]) {
					link += arr[i][j];
					link += arr[j][i];
				}
				
			}
			
		}
		int val = Math.abs(start-link);
		min = Math.min(val, min);
	}

}