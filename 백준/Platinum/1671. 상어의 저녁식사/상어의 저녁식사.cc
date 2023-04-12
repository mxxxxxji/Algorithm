//백준 1671번
#include <iostream>
#include <vector>
#define MAX 1001

using namespace std;


vector<int> a[MAX];
int statt[MAX][3];
int d[MAX];
bool c[MAX];
int n;

bool dfs(int x) {
	for (int i = 0; i < a[x].size(); i++) {
		int y = a[x][i];
		if (c[y]) continue;
		c[y] = true;
		if (d[y] == 0 || dfs(d[y])) {
			d[y] = x;
			return true;
		}
	}
	return false;
}

int main(void) {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		int a, b, c;
		scanf("%d %d %d", &a, &b, &c);
		statt[i][0] = a;
		statt[i][1] = b;
		statt[i][2] = c;
	}
	for (int i = 1; i <= n-1; i++) {
		for (int j = i + 1; j <= n; j++) {
			if (statt[i][0] == statt[j][0] && statt[i][1] == statt[j][1] && statt[i][2] == statt[j][2]) {
				a[i].push_back(j);//상어 i와 상어 j가 스탯이 같을 때
			}
			else if (statt[i][0] >= statt[j][0] && statt[i][1] >= statt[j][1] && statt[i][2] >= statt[j][2]) {
				a[i].push_back(j);//상어 i가 상어 j보다 스탯이 클 때
			}
			else if (statt[i][0] <= statt[j][0] && statt[i][1] <= statt[j][1] && statt[i][2] <= statt[j][2]) {
				a[j].push_back(i);//상어 i가 상어 j보다 스탯이 작을 때
			}
		}
	}
	int count = 0;
	for (int k = 0; k < 2; k++) {
		for (int i = 1; i <= n; i++) {
			fill(c, c + MAX, false);
			if (dfs(i)) count++;
		}
	}
	printf("%d\n", n - count); //전체상어의 갯수 - 잡아먹힌 상어(매칭이된)
	return 0;
}