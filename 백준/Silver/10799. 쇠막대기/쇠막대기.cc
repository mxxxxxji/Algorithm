#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main(void) {
	int result=0;
	stack<char> s;
	string str;
	cin >> str;
	for (int i = 0; i < str.length(); i++) {
		if (str[i] == '(') {
			s.push(str[i]);
		}
		else {
			s.pop();
			if (str[i-1] == '(') {
				result += s.size();
			}
			else {
				result++;
			}
		}
	}
	cout << result;
	return 0;
}