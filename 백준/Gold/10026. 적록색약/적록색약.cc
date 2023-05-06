#include <iostream>
#include <queue>

using namespace std;

int n;
char map[100][100];
bool visit[100][100] = { false, };
int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
int result1;
int result2;
void bfs(int a, int b) {
	queue<pair<int, int>> q;
	char color;
	if (!visit[a][b]) {
		q.push({ a, b });
		color = map[a][b];
		while (!q.empty()) {
			int y = q.front().first;
			int x = q.front().second;
			q.pop();
			for (int i = 0; i < 4; i++) {
				int dy = y + dir[i][0];
				int dx = x + dir[i][1];

				if (dy < 0 || dx < 0 || dy >= n || dx >= n) continue;
				if (!visit[dy][dx] && color == map[dy][dx]) {
					visit[dy][dx] = true;
					q.push({ dy, dx });
				}
			}
		}
		result1++;
	}
}
void Bfs(int a, int b) {
	queue<pair<int, int>> q;
	char color;
	if (!visit[a][b]) {
		q.push({ a, b });
		color = map[a][b];
		while (!q.empty()) {
			int y = q.front().first;
			int x = q.front().second;
			q.pop();
			for (int i = 0; i < 4; i++) {
				int dy = y + dir[i][0];
				int dx = x + dir[i][1];

				if (dy < 0 || dx < 0 || dy >= n || dx >= n) continue;
				if (!visit[dy][dx]) {
					if (map[dy][dx] == 'B') {
						if (color == map[dy][dx]) {
							visit[dy][dx] = true;
							q.push({ dy, dx });
						}
					}
					else { //R or G
						if (color != 'B') {
							visit[dy][dx] = true;
							q.push({ dy, dx });
						}
						
					}			
				} 
			}
		}
		result2++;
	}
}
void input() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
		}
	}
}
void solution() {
	input();
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			bfs(i, j);
		}
	}
	//초기화
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			visit[i][j] = false;
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			Bfs(i, j);
		}
	}
	cout << result1<< " " <<result2 << endl;
}
int main(void) {
	solution();
	return 0;
}