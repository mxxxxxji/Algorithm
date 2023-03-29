#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#define MAX 100001

using namespace std;

int	n, k;
queue<int> q;
int c[MAX];

void bfs()
{
	q.push(n);
	c[n] = 0;
	while (!q.empty()) {
		int x = q.front();
		q.pop();

		if (x == k) return; //종료조건

		int dx;
		for (int i = 0; i < 3; i++) {
			if (i == 0) dx = x - 1;
			else if (i == 1) dx = x + 1;
			else if(i == 2) dx = 2 * x;

			if (dx >= 0 && dx < MAX && c[dx] == 0) {
				q.push(dx);
				c[dx] = c[x] + 1;
			}
		}
	}
}

int main(void){
	
	scanf("%d %d", &n, &k);
	bfs();
	printf("%d", c[k]);
}