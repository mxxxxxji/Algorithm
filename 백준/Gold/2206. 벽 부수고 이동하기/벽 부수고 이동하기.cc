#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#define MAX 1001

using namespace std;

int n, m;
int arr[MAX][MAX];
int c[MAX][MAX][2];
queue<pair<pair<int, int>, int>> q; //x, y, 벽뚫기
int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };//상하좌우

int bfs(void) {
	q.push(make_pair(make_pair(0,0), 1));
	c[0][0][1] = 1;
	while (!q.empty()) {
		int x = q.front().first.first;
		int y = q.front().first.second;
		int block = q.front().second;
	
		q.pop();

		//도착했을 경우
		if (x ==  n- 1 && y == m - 1) {

			return c[x][y][block];
		}

		for (int i = 0; i < 4; i++) {

			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if (dx >= 0 && dy >= 0 && dx < n && dy <m) {
				//벽이 있고, 벽을 뚫지 않은 경우
				if (arr[dx][dy] == 1 && block) {
		
				
					c[dx][dy][block - 1] = c[x][y][block] + 1;
					q.push(make_pair(make_pair(dx, dy), block - 1));
				}
				//벽이 없고, 방문하지 않은 경우
				if (arr[dx][dy] == 0 && c[dx][dy][block] == 0) {
			
					c[dx][dy][block] = c[x][y][block] + 1;
					q.push(make_pair(make_pair(dx, dy), block));
				}
			}
		}
	}
	return -1;
}
int main(void) 
{
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1d", &arr[i][j]);
		}
	}
	
	printf("%d\n", bfs());
	return 0;
}