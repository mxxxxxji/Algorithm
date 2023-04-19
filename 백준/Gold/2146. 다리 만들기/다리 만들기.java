import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int cntIsland=2;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][N];
		// 섬 구분
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					bfs1(i, j);
					cntIsland++;
				}
			}
		}
		visited = new boolean[N][N];
		// 다리연결
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]>0 && !visited[i][j]) {
					bfs2(i, j);
					visited = new boolean[N][N];
				}
			}
		}
		
		System.out.println(result);
	}
	static void bfs2(int y, int x) {
		
		int curIsland = map[y][x];
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y,x,0));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
				Pos p = q.poll();
				
				if(p.w>=result) continue;
				
				for(int i=0; i<4; i++) {
					int ny = p.y + dy[i];
					int nx = p.x + dx[i];
					
					if(!check(ny, nx) || map[ny][nx]==curIsland || visited[ny][nx]) continue;
					
					if(map[ny][nx]==0) { //바다
						visited[ny][nx] = true;
						q.add(new Pos(ny, nx, p.w+1));
					}else { //섬
						result = Math.min(result, p.w);
					}
				}
		}
	}
	static void bfs1(int y, int x) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y,x));
		visited[y][x] = true;
		map[y][x] = cntIsland; 
		while(!q.isEmpty()) {
				Pos p = q.poll();
				for(int i=0; i<4; i++) {
					int ny = p.y + dy[i];
					int nx = p.x + dx[i];
					
					if(check(ny, nx) && !visited[ny][nx] && map[ny][nx]==1) {
						visited[ny][nx] = true;
						map[ny][nx] = cntIsland;
						q.add(new Pos(ny, nx));
					}
				}
		}
	}
	static boolean check(int y, int x) {
		if(y<0 || x<0 || y>=N || x>=N) return false;
		return true;
	}
	static class Pos{
		int y;
		int x;
		int w;
		public Pos(int y, int x, int w) {
			this.y=y;
			this.x=x;
			this.w=w;
		}
		public Pos(int y, int x) {
			this.y=y;
			this.x=x;
		}
	}

}