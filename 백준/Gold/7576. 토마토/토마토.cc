#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#define MAX 1001

using namespace std;

int m, n;
int a[MAX][MAX];
queue<pair<int, int>> q;
int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };//상하좌우
int result;

void bfs() {

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if (dx >= 0 && dy >= 0 && dx < n && dy < m) {

				if (a[dx][dy] == 0) {
					a[dx][dy] = a[x][y] + 1;
					q.push(make_pair(dx, dy));
				}
			}
		}
	}

}


int main(void) {

	scanf("%d %d", &m, &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &a[i][j]);
			if (a[i][j] == 1) {

				q.push(make_pair(i, j));
			}
		}
	}

	bfs();

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] == 0) { //익지못한 토마토가 있는 상황
				printf("%d\n", -1);
				return 0;
			}
			if (result < a[i][j]) { //토마토가 다 익음
				result = a[i][j];
			}
		}
	}

	printf("%d\n", result - 1);
	return 0;
}



//도움받은곳ㅠㅠ-https://jdselectron.tistory.com/55