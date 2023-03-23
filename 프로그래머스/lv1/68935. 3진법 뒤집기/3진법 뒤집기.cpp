#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int n) {
	int answer = 0;
	string str = "";

	while (n > 0) {
		int tmp = n % 3;
		n = n / 3;
		str += to_string(tmp);
	}

	for (int i = str.length()-1; i >=0; i--) {
		int p = str[i] - '0';
		answer += pow(3, str.length()-1-i) * p;
	}
	return answer;
}