#include <iostream>
#include <cstring>
using namespace std;

int n;
int arr[101];
long long before[21];
long long current[21];
int result;
int main() {
	cin >> n;
	for (int i = 0; i < n - 1; i++) {
		cin >> arr[i];
	}
	cin >> result;
	
	before[arr[0]] = 1; //초기값
	for (int i = 1; i < n - 1; i++) {
		memset(current, 0, sizeof(current));
		for (int j = 0; j <= 20; j++) {
			if (before[j] != 0) {
				int plus = j + arr[i];
				if (plus <= 20) {
					current[plus] += before[j];
				}
				int minus = j - arr[i];
				if (minus >= 0) {
					current[minus] += before[j];
				}
			}
		}
		for (int k = 0; k <= 20; k++) {
			before[k] = current[k];
		}
	}

	cout << current[result] << endl;

	return 0;
}