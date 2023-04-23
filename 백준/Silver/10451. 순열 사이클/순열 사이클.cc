#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstring>
#define MAX 10001

using namespace std;
 
int t;
int a[MAX];
bool c[MAX];
int cnt;

void dfs(int x) {
	if (c[x]) return;
	c[x] = true;
	if (!c[a[x]]) {
		dfs(a[x]);
	}
}

int main(void) {

	scanf("%d", &t);
	while (t--) {
		int n = 0;
		scanf("%d", &n);
		for (int i = 1; i <= n; i++) {
			scanf("%d", &a[i]);
		}
		for (int i = 1; i <= n; i++) {
			if (!c[i]) {
				dfs(i);
				cnt++;
			}
		
		}
		printf("%d\n", cnt);
		memset(c, false, sizeof(c));
		cnt = 0;
	}
	return 0;
}