//9663번
#include <iostream>
#include <algorithm>
using namespace std;

int N;
int cnt; // 방법의 수
int arr[15];

int possible(int cdx) {
	for (int i = 0; i < cdx; i++) { //열
		//같은 열이거나, 대각선상에 놓였다면
		if (arr[cdx] == arr[i] || abs(arr[cdx] - arr[i]) == abs(cdx - i))
			return 0;
	}
	return 1;
}

void nqueen(int cdx) {//행마다 퀸을 둔다
	//마지막 행까지 퀸을 두는 것을 모두 수행했다면, 탐색 끝
	if (cdx == N) {
		cnt++;
		return;
	}
	for (int i = 0; i < N; i++) {
		//cdx행에 i번째 열에 queen을 둔다
		arr[cdx] = i;
		//그 자리에 두는 것이 괜찮다면
		if (possible(cdx)) { 
			nqueen(cdx + 1); //다음 행에 대해 퀸을 둔다
		}
	}

}
void solution() {
	cin >> N;
	nqueen(0);
	cout << cnt << endl;
}
int main(void) {
	solution();
	return 0;
}