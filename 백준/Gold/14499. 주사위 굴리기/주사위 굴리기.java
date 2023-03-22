import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	static int N;
	static int M;
	static int x;
	static int y;
	static int K;

	static int[][] map;
	static int[][] dice;

	private static void east() {
		int t = dice[1][1];

		dice[1][1] = dice[1][0];
		dice[1][0] = dice[3][1];
		dice[3][1] = dice[1][2];
		dice[1][2] = t;
	}

	private static void west() {
		int t = dice[1][1];

		dice[1][1] = dice[1][2];
		dice[1][2] = dice[3][1];
		dice[3][1] = dice[1][0];
		dice[1][0] = t;
	}

	private static void north() {
		int t = dice[1][1];

		dice[1][1] = dice[2][1];
		dice[2][1] = dice[3][1];
		dice[3][1] = dice[0][1];
		dice[0][1] = t;
	}

	private static void south() {
		int t = dice[1][1];

		dice[1][1] = dice[0][1];
		dice[0][1] = dice[3][1];
		dice[3][1] = dice[2][1];
		dice[2][1] = t;
	}

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dice = new int[4][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < K; i++) {
			int command = Integer.parseInt(st.nextToken());

			int nx = x + dx[command]; // 세로
			int ny = y + dy[command];

			if (ny < 0 || ny >= M || nx < 0 || nx >= N)
				continue;

			switch (command) {
			case 1:
				east();
				break;
			case 2:
				west();
				break;
			case 3:
				north();
				break;
			case 4:
				south();
				break;
			default:
				break;
			}

			if (map[nx][ny] == 0) {
				map[nx][ny] = dice[3][1];
			} else {
				dice[3][1] = map[nx][ny];
				map[nx][ny] = 0;
			}

			y = ny;
			x = nx;
			
			sb.append(dice[1][1]).append("\n");
		}

		System.out.print(sb.toString());

		br.close();
	}

}