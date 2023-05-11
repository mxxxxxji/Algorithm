#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <queue>
#define MAX 8

using namespace std;

int N, M; //세로 가로
int Map[MAX][MAX];
int Tmp[MAX][MAX];

int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };//상하좌우
int result;
void spread_virus() {
	
	int Tmp2[MAX][MAX];
	//배열 복사
	for (int i = 0; i < N; i++) {
		copy(Tmp[i], Tmp[i] + M, Tmp2[i]);
	}
	queue <pair<int, int>> q;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (Tmp2[i][j] == 2) 
				q.push(make_pair(i, j));
		}
	}

	while (!q.empty()) {
		int y = q.front().first;
		int x = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int dy = y + dir[i][0];
			int dx = x + dir[i][1];
			if (dy >= 0 && dx >= 0 && dy < N && dx < M) {
				if (Tmp2[dy][dx] == 0) {
					Tmp2[dy][dx] = 2;
					q.push(make_pair(dy, dx));
				}
			}
 		}
	}
	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (Tmp2[i][j] == 0)
				cnt+=1;
		}
	}

	result = max(result, cnt);

}
void make_wall(int wall_cnt) {//벽 세우기
	//바이러스를 퍼트렸을 때 0이 최댓값이면 종료
	if (wall_cnt == 3) {
		spread_virus();
		return;
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (Tmp[i][j] == 0) {
				Tmp[i][j] = 1;
				make_wall(wall_cnt + 1);
				Tmp[i][j] = 0;
			}
		}
	}
	

}

int main(void) {

	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &Map[i][j]);
		}
	}
	/*for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			printf("%d ", Map[i][j]);
		}
		printf("\n");
	}*/

	
	/*for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			printf("%d ", Tmp[i][j]);
		}
		printf("\n");
	}*/
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (Map[i][j] == 0) {
				//배열 복사
				for (int a = 0; a < N; a++) {
					copy(Map[a], Map[a] + M, Tmp[a]);
				}
				Tmp[i][j] = 1;
				make_wall(1);
				Tmp[i][j] = 0;
			}
		}
	}
	
	cout << result << endl;
	return 0;
}