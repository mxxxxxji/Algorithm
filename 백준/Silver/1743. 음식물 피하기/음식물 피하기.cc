#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n, m, k;
vector<pair<int, int>> vc;
int map[101][101];
int dir[4][2] = { {-1,0}, {1,0}, {0,-1}, {0,1} };
vector<int> food;
int cnt = 1;
void BFS(int a, int b) {
	queue<pair<int, int>> q;

	q.push({a,b});
	map[a][b] = 2;

	while (!q.empty()) {
		int y = q.front().first;
		int x = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int dy = y + dir[i][0];
			int dx = x + dir[i][1];
			if (dy<1 || dx<1 || dy>n || dx>m) continue;
			if (map[dy][dx] != 2 && map[dy][dx] == 1) {
				map[dy][dx] = 2;
				q.push({ dy, dx });
				cnt++;
			}
		}
	}
	
}
void Solution() {
	
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (map[i][j] != 2 && map[i][j] == 1) {
				BFS(i, j);
				food.push_back(cnt);
				cnt = 1;
			}
		}
	}
	sort(food.begin(), food.end(), greater<>());

	cout << food[0] << endl;

}

void Input() {
	cin >> n >> m >> k;
	for (int i = 0; i < k; i++) {
		int a, b;
		cin >> a >> b;
		map[a][b] = 1;
	}
	
}

int main(void) {
	Input();
	Solution();
	return 0;
}