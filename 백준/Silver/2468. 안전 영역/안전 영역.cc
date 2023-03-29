#include <iostream>
#include <algorithm>

using namespace std;

int N;
int map[101][101];
int area[101][101];
int dir[4][2] = { {1,0}, {-1,0}, {0,-1}, {0,1} };

void DFS(int y, int x, int h) {

	for (int i = 0; i < 4; i++) {
		int dy = y + dir[i][0];
		int dx = x + dir[i][1];
		if (dy >= N || dx >= N || dy < 0 || dx < 0) continue;
		if (area[dy][dx]>h && area[dy][dx] != -1) {
			area[dy][dx] = -1;
			DFS(dy, dx, h);
		}
	}
}
void solution() {
	int answer = 1;
	for (int h = 1; h <= 100; h++) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
					area[i][j] = map[i][j];
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (area[i][j] > h && area[i][j] != -1) //방문하지 않은 곳이라면
				{
					area[i][j] = -1;
					cnt++;
					DFS(i, j, h);
				}
			}
		}
		answer = max(answer, cnt);
	}
	cout << answer << endl;
}

int main(void) {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}

	solution();
	
	return 0;
}