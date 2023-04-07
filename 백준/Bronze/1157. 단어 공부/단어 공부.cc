#include <iostream>
#include <string>

using namespace std;
const string arr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?";
int cnt[26];
int a_max;
int idx;

int main(void) {
	
	string word;
	cin >> word;

	
	for (int i = 0; i < word.length(); i++) {
		word[i] = toupper(word[i]);
		for (int j = 0; j < 26; j++) {
			if (word[i] == arr[j]) {
				cnt[j]++;
			}
		}
		
	}

	for (int i = 0; i < sizeof(cnt)/sizeof(int); i++) {
		if (cnt[i] == 0) {
			continue;
		}
		if ( a_max == cnt[i]) {
			idx = 26;
			continue;
		}
		if (a_max < cnt[i]) {
			a_max = cnt[i];
			idx = i;
		}
	}
	cout << arr[idx];
	return 0;
}