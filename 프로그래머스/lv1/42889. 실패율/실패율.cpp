#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int, double> a, pair<int, double> b) {
	if (a.second == b.second) return a.first < b.first;
	return a.second > b.second; //내림차순
}

vector<int> solution(int N, vector<int> stages) {

	vector<int> answer;
	vector<int> count(N + 1); //누적스테이지
	vector<pair<int, double>> fail;
	for (int i = 0; i < count.size(); i++) {
		for (int j = 0; j < stages.size(); j++) {
			if (i + 1 == stages[j]) {
				count[i]++;
			}
		}
		if (i > 0) {
			count[i] += count[i - 1]; //누적
		}
	}

	for (int i = 0; i < N; i++) {
		fail.push_back({ i, 0 });
	}

	//첫번째 스테이지는 무조건 모두가 도전
	fail[0].second = count[0] / (double)stages.size();
	//두번째 스테이지부터
	for (int i = 1; i < fail.size(); i++) {
		if (count[i] - count[i - 1] == 0) { //스테이지에 도달한사람이 없을 경우 실패율은 0으로 정의
			fail[i].second = 0;
		}
		else {
			fail[i].second = (count[i] - count[i - 1]) / (double)(stages.size() - count[i - 1]);
		}
		
	}

	//실패율 내림차순으로 정렬
	sort(fail.begin(), fail.end(), compare);

	//answer에 순서대로 넣기
	for (int i = 0; i < N; i++) {
		answer.push_back(fail[i].first + 1);
	}
	return answer;
}