import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{1, 0}, {0, 1}};
	static String res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = "Hing";
		visited[0][0] = true;
		dfs(0,0);
		System.out.println(res);
	}
	public static void dfs(int r, int c) {
		if(r==N-1 && c==N-1) {
			res = "HaruHaru";
			return;
		}
		for(int i=0; i<2; i++) {
			int nr = r + dir[i][0]*map[r][c];
			int nc = c + dir[i][1]*map[r][c];
			
			if(nr<0 || nc<0 || nr>N-1 || nc>N-1)continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr, nc);
		}
	}
}