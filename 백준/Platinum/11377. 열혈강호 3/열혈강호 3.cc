//백준 11377번
#include <iostream>
#include <vector>
#define MAX 1001

using namespace std;

int n, m, k;
vector<int> a[MAX];
int d[MAX];
bool c[MAX];

bool dfs(int x) {
	for (int i = 0; i < a[x].size(); i++) {
		int t = a[x][i];
		if (c[t]) continue;
		c[t] = true;
		if (d[t] == 0 || dfs(d[t])) {
			d[t] = x;
			return true;
		}
	}
	return false;
}

int main(void) {
	scanf("%d %d %d", &n, &m, &k);
	for (int i = 1; i <= n; i++) {
		int s;
		scanf("%d", &s);
		for (int j = 1; j <= s; j++) {
			int t;
			scanf("%d", &t);
			a[i].push_back(t);
		}
	}

	int count = 0;
	for (int i = 1; i <= n; i++) {
		fill(c, c + MAX, false);
		if (dfs(i)) count++;
	}
	//두 번씩 작업할 수 있는 사람을 추가적으로 계산
	int extra = 0;
	for (int i = 1; i <= n && extra < k; i++) {
		fill(c, c + MAX, false);
		if (dfs(i)) extra++;
	}
	printf("%d\n", count+extra);
	return 0;
}