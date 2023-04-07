

#include <iostream>
#include <queue>

using namespace std;

queue<int> q;
int n, k;

int main(void) {
	cin >> n;
	cin >> k;
	for (int i = 1; i <= n; i++) {
		q.push(i);
	}
	cout << "<";
	while (!q.empty()) {
		for (int i = 0; i < k - 1; i++) {
			int num = q.front();
			q.pop();
			q.push(num);
		}
		cout << q.front();
		q.pop();
		if (!q.empty()) {
			cout << ", ";
		}
	}
	cout << ">";
	return 0;
}
