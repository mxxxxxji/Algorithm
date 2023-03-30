import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static char map[][];
	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static int res_move;
	static int res_pin;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=N; tc++) {
			map = new char[5][9];
			int pin = 0;
			
			for(int i=0; i<5; i++) {
				String s = br.readLine();
				for(int j=0; j<9; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j]=='o') pin++;
				}
			}
			
			res_pin = pin;
			res_move = 0;
			for(int i=0; i<5; i++) {
				for(int j=0; j<9; j++) {
					if(map[i][j]=='o') dfs(i, j, pin, 0);
				}
			}
			br.readLine();
			System.out.println(res_pin + " " + res_move);
		}
	}
	
	public static void dfs(int y, int x, int cur_pin, int move) {
		
		if(cur_pin <= res_pin) { // 핀이 줄어들었으면
			res_pin = cur_pin;
			res_move = move;
		}
		
		for(int d=0; d<4; d++) {
			// 다음 칸
			int dy = y + dir[d][0];
			int dx = x + dir[d][1];
			
			if(dy<0 || dx<0 || dy>=5 || dx>=9) continue;
			// 인접한 다음칸에 핀이 있고
			if(map[dy][dx]=='o') {
				// 다다음 칸
				int ddy = dy + dir[d][0];
				int ddx = dx + dir[d][1];
				
				if(ddy<0 || ddx<0 || ddy>=5 || ddx>=9) continue;
				// 다음 핀의 다음 칸은 비어 있다면
				if(map[ddy][ddx]=='.') {
					
					map[y][x] = map[dy][dx] = '.';
					map[ddy][ddx] = 'o';
					
					for(int i=0; i<5; i++) {
						for(int j=0; j<9; j++) {
							if(map[i][j]=='o') dfs(i, j, cur_pin-1, move+1);
						}
					}
					map[y][x] = map[dy][dx] = 'o';
					map[ddy][ddx] = '.';
				}
			}
			
		}
	}
}