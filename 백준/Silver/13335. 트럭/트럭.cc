#include <iostream>
#include <queue>

using namespace std;

int n, w, L;
queue<int> q;
int truck[1000];
int time;

int main(void) {
	
	cin >> n;
	cin >> w;
	cin >> L;

	int sum = 0;

	for (int i = 0; i < n; i++)
		cin >> truck[i];

	for (int i = 0; i < n; i++) {
		while (1) {
			if (q.size() == w) {
				sum -= q.front();
				q.pop();
			}
			if (truck[i] + sum <= L) break;
			q.push(0);
			time++;
		}
		q.push(truck[i]);
		sum += truck[i];
		time++;
	}
	cout << time + w;

	return 0;
}