#include <iostream>
#include <queue>
#define N 101
#define M 101
using namespace std;


int Domino[N][M]; //초기 게임판의 상태
int Game[N][M];	//게임 후 게임판

int dir[4][2] = { {-1,0}, {1,0}, {0,-1}, {0,1} }; //오류난 부분
int n, m;
int result;
int cnt;
void Down(int y, int x, int d) {
	//시작점에서 위치갱신
	int dy = y + dir[d][0];
	int dx = x + dir[d][1];
	//시작 위치의 숫자만큼 도미노 넘어트리기(시작점 빼고)
	for (int i = 1; i < Domino[y][x]; i++) {
		if (dy >= 0 && dx >= 0 && dy < n && dx < m) { //판 내에 있고
			if (Game[dy][dx]) { //넘어지지 않았다면
				Game[dy][dx] = 0; //넘어트리고
				cnt++;
				Down(dy, dx, d);
			}
		}
		//위치 갱신을 여기서 돌려야 if문 내의 재귀함수가 돌아감
		dy = dy + dir[d][0];
		dx = dx + dir[d][1];
	}

}
int main(void) {
	cnt = 0;
	int R;
	cin >> n >> m >> R;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> Domino[i][j];
			Game[i][j] = 1; //초기 모두 S로 설정
		}
	}
	/*	printf("domino\n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cout <<  Domino[i][j]<< " " ;

			}
			printf("\n");
		}
		printf("game\n");
		for (int i = 0; i <n; i++) {
			for (int j = 0; j < m; j++) {

				cout << Game[i][j] << " "; //초기 모두 S로 설정
			}
			printf("\n");
		}*/

	while (R--) {
		int y1, x1;
		int y2, x2;
		char d;

		//공격
		cin >> y1 >> x1 >> d;

		//cout << y1 << x1 << endl;
		//cout << d << endl;

		/*for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				cout << Game[i][j] << " "; //초기 모두 S로 설정
			}
			printf("\n");
		}*/

		int d_num = 0;
		if (d == 'N') d_num = 0;
		else if (d == 'S') d_num = 1;
		else if (d == 'W') d_num = 2;
		else if (d == 'E') d_num = 3;

		
		Game[y1 - 1][x1 - 1] = 0;  //시작점 넘어트리기
		cnt++;
		Down(y1 - 1, x1 - 1, d_num); 

		//수비
		cin >> y2 >> x2;
		
		//수비하는 곳이 도미노가 쓰러져 있다면
		if (!Game[y2 - 1][x2 - 1]) Game[y2 - 1][x2 - 1] = 1; // (y, x)도미노를 다시 세움

		
	}
	cout << cnt << endl;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cout << (Game[i][j] ? "S " : "F ");
		cout << '\n';
	}

	return 0;
}
