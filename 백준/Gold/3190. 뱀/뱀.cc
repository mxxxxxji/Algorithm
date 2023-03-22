#include <iostream>
#include <queue>


using namespace std;

int n, k, l;
int map[101][101]; //사과있는 지도
int snake_map[101][101];//뱀있는 지도
queue<pair<int, char>> s_move; //뱀의 움직임
queue<pair<int, int>> snake;//뱀이있는곳
pair <int, int> s_head; //뱀 머리 위치
pair <int, int> s_tail; //뱀 머리 꼬리 위치
int s_len;//뱀 길이
int w;//현재 뱀의 방향
int time;//게임 진행 시간
int dir[4][2] = { {-1,0}, {0, 1}, {1, 0}, {0,-1} };
int flag;
int q_size;
void change(int _x, char _c) {
	if (_c == 'D') {

		if (w == 3)
			w = 0;
		else w++;

	}
	else {

		if (w == 0)
			w = 3;
		else w--;

	}
	while (1) {
		time++;
		
		int cy = s_head.first + dir[w][0];
		int cx = s_head.second + dir[w][1];
	
		if (map[cy][cx] == 2) {
			flag = 0; break; //뱀의 몸과 부딪힌 경우
		}
		if (cy < 0 || cx < 0 || cy >= n || cx >= n) {
			flag = 0; break; //벽과 부딪힌 경우
		} 
		if (map[cy][cx] == 1) {//사과가 있다면
		
			map[cy][cx] = 0;//사과 먹기
			map[cy][cx] = 2;//뱀이 있는 곳 표시;
			s_len++; //몸 길이+1
			s_head = { cy, cx }; //머리 위치 변경
			snake.push({ cy, cx }); //다음 몸뚱아리 넣어준다
		}else { //사과가 없다면

			map[cy][cx] = 2;//뱀이 있는 곳 표시;
			s_head = { cy, cx }; //머리 위치 변경
			snake.push({ cy, cx }); //다음 몸뚱아리 넣어준다

			int y = snake.front().first;
			int x = snake.front().second;
		
			map[y][x] = 0; //꼬리있던 부분을 지워준다
			snake.pop();//꼬리 줄여준다

		}
		if (time == _x) {
			if (_c == 'D') {
		
				if (w == 3)
					w = 0;
				else w++;


			}
			else {
				if (w == 0)
					w = 3;
				else w--;
			
			}
		}
	


	
		if (q_size > 0) {
			if (time >= s_move.front().first) break;
		}
		else continue;
	
			
	}

}

int main(void) {
	//입력
	cin >> n;
	cin >> k;
	for (int i = 0; i < k; i++) {
		int x, y;
		cin >> x >> y;
		map[x - 1][y - 1] = 1; //사과 넣기
	}
	cin >> l;
	for (int i = 0; i < l; i++) {
		int x; 
		char c;
		cin >> x >> c;
		s_move.push({ x, c });
	}

	//시작
	s_head = { 0, 0 };
		//s_tail = { 0,0 };
	w = 0;
	snake.push({ 0, 0 });
	flag = 1;

	while (!s_move.empty() && flag==1) {
		int x = s_move.front().first;
		char c = s_move.front().second;
		s_move.pop();
		q_size = s_move.size();
		
		change(x, c);
		
	}
	

	cout << time << endl;
	return 0;
}
