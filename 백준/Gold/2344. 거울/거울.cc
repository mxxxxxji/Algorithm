#include <iostream>

using namespace std;

int n, m;
int map[1005][1005];
int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
int change(int d) {
	if (d == 0) return 3;
	else if (d == 1) return 2;
	else if (d == 2)return 1;
	else return 0;

}
int find(int y, int x, int w) { //시작 숫자, 방향

	int dy = y + dir[w][0];
	int dx = x + dir[w][1];

	
	if (map[dy][dx] >= 1) {
		return map[dy][dx];
	}
	else {
		if (map[dy][dx] == -1) {//거울이 있다면

			return find(dy, dx, change(w));
		}
		else{//거울이 없다면

			return find(dy, dx, w);
		}
	}

}
int main(void) {
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) {
				map[i][j] = -1;//거울
			}

		}
	}
	for (int i = 1; i <= n; i++) { //좌, 우 
		map[i][0] = i;
		map[n + 1 - i][m + 1] = m + n + i;
	}
	for (int i = 1; i <= m; i++) { //하, 상
		map[n + 1][i] = n + i;
		map[0][m + 1 - i] = 2 * n + m + i;
	}
	
	for (int i = 1; i <= n; i++) {
		cout << find(i, 0, 3) << " ";
	}
	for (int i = 1; i <= m; i++) {
		cout << find(n + 1, i, 0)<< " ";
	}
	for (int i = n; i > 0; i--) {
		cout << find(i, m + 1, 2)<< " ";
	}
	for (int i = m; i > 0; i--) {
		cout << find(0, i, 1) << " ";
	}
	return 0;
}