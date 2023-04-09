#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std; 

int n, m;
int info[101][101];
int visited[101];
int cnt[101];
queue<int> q;
int tmp=101;

bool BFS(int num) {
	q.push(num);
	visited[num] = 1;
	while (!q.empty()) {
		int user = q.front();
		q.pop();
		for (int i = 1; i <= n; i++) {
			if (!visited[i] && info[user][i]) {
				cnt[i] = cnt[user] + 1;
				q.push(i);
				visited[i] = 1;
			}
		}
	}
	int sum = 0;
	for (int i = 1; i <= n; i++) {
		sum += cnt[i];
	}
	if (sum < tmp) {
		tmp = sum;
		return true;
	}
	else return false;
}
void solution() {
	int result;
	for (int i = 1; i <= n; i++) {
		if (BFS(i)) result = i;
		memset(visited, false, sizeof(visited));
		memset(cnt, 0, sizeof(cnt));
	}
	cout << result;
}
int main(void) {
	
	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		info[a][b] = 1;
		info[b][a] = 1;
	
	}
	solution();
	return 0;
}