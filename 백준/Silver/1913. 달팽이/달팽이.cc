#include <iostream>
using namespace std;

int N;			//입력받을 크기
int findNum;			//찾고자 하는 수
int snail[1000][1000];  //숫자를 달팽이 모양으로 채울 배열

void makeSnail() {
	int y = N / 2 + 1;
	int x = N / 2 + 1;
	snail[y][x] = 1;

	int num = 2; // 배열에 넣을 숫자
	int move_count = 0;
	while (true) {

		move_count++;

		//위
		for (int i = 0; i < move_count; i++) {
			y = y - 1;
			snail[y][x] = num;
			num++;
			if (num > N * N) break;
		}
		if (num > N * N) break;

		//우
		for (int i = 0; i < move_count; i++) {
			x = x + 1;
			snail[y][x] = num;
			num++;
		}

		move_count++;

		//아래
		for (int i = 0; i < move_count; i++) {
			y = y + 1;
			snail[y][x] = num;
			num++;
		}

		//좌
		for (int i = 0; i < move_count; i++) {
			x = x - 1;
			snail[y][x] = num;
			num++;
		}
	}
}

void Print() {

	int PointY, PointX;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cout << snail[i][j] << " ";
			if (snail[i][j] == findNum) {
				PointY = i;
				PointX = j;
			}
		}
		cout << "\n";
	}

	cout << PointY << " " << PointX << "\n";
}

int main() {
	cin >> N;
	cin >> findNum;
	makeSnail();				
	Print(); 
}
