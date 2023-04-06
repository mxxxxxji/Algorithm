#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <cstring>
#define MAX 51

using namespace std;

int t;
int m, n, k;
int arr[MAX][MAX];
bool c[MAX][MAX];
int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };//상하좌우
queue<pair<int,int>> q;
int result;

void bfs(int a, int b) {
	q.push(make_pair(a, b));
	c[a][b] = true;

	while (!q.empty()) 
	{
		int x = q.front().first;
		int y = q.front().second;

		q.pop();

		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if (dx >= 0 && dx < 50 && dy >= 0 && dy < 50) {
				if (arr[dx][dy] && !c[dx][dy]) {
					q.push(make_pair(dx, dy));
					c[dx][dy] = true;
				}
			}
		}
		 
	}
}

int main(void) {

	scanf("%d", &t);
	
	while(t--) {
		scanf("%d %d %d", &m, &n, &k);
		
		for (int i = 0; i < k; i++) {
			int x=0, y=0;
			scanf("%d %d", &x, &y);
			arr[x][y] = 1;

		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!c[i][j] && arr[i][j]) {
					bfs(i, j);
					result++;
				}
			}
		}
		printf("%d\n", result);
		result = 0;
		memset(c, 0, sizeof(c));
		memset(arr, 0, sizeof(arr));
	}

	return 0;
}