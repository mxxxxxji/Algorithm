#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> student1 = {1, 2, 3, 4, 5};//5
    vector<int> student2 = {2, 1, 2, 3, 2, 4, 2, 5};//8
    vector<int> student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};//10
    int cnt[3] = {0, };
    for(int i = 0; i < answers.size(); i++){
        if(answers[i] == student1[i % 5]) cnt[0]++;
        if(answers[i] == student2[i % 8]) cnt[1]++;
       	if(answers[i] == student3[i % 10]) cnt[2]++;
    }
    int max = *max_element(cnt, cnt+3);
    for(int i = 0; i < 3; i++){
        if(max == cnt[i]) answer.push_back(i + 1);
    }

    sort(answer.begin(), answer.end());
    return answer;
}