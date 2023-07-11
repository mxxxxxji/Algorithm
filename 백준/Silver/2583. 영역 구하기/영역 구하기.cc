#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int M, N, K;
int map[101][101];
int visited[101][101];
int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
int cnt;
vector<int> vc;
void DFS(int y, int x) {
	cnt++;
	visited[y][x] = 1;
	for (int i = 0; i < 4; i++) {
		int dy = y + dir[i][0];
		int dx = x + dir[i][1];
		if (dy >= M || dx >= N || dy < 0 || dx < 0) continue;
		if (map[dy][dx] == 0 && !visited[dy][dx]) {
			DFS(dy, dx);
		}
	}
}

int main(void) {
	
	cin >> M >> N >> K;
	for (int i = 0; i < K; i++) {
		int x1, x2, y1, y2;
		cin >> x1 >> y1 >> x2 >> y2;
		for (int j = y1; j < y2; j++) {
			for (int k = x1; k < x2; k++) {
				map[j][k] = 1;
			}
		}
	}
/*	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			cout << map[i][j] << " ";
		}
		cout << endl;
	}*/
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (!visited[i][j] && map[i][j] == 0) {
				cnt = 0;
				DFS(i, j);
				vc.push_back(cnt);
			}
		
		}
	}
	sort(vc.begin(), vc.end());
	cout << vc.size() << endl;
	for (int i = 0; i < vc.size(); i++) {
		cout << vc[i] << " ";
	}
	return 0;
}