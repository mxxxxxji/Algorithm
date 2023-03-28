#include <string>
#include <vector>
#include <algorithm>
using namespace std;


string solution(vector<int> numbers, string hand) {
    string answer = "";
    int left = 10;
    int right = 12;
 
    for(int i = 0; i < numbers.size(); i++){
        if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
            answer += "L";
            left = numbers[i];
        }
        else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
            answer += "R";
            right = numbers[i];
        }else{
            if(numbers[i]==0) numbers[i]=11;
            int leftDist = abs(numbers[i] - left)/3 +abs(numbers[i] - left)%3;
            int rightDist = abs(numbers[i]-right)/3 + abs(numbers[i] - right)%3;
            if(leftDist > rightDist){
                answer += "R";
                right = numbers[i];
            }else if(leftDist < rightDist){
                answer += "L";
                left = numbers[i];
            }else {
                if(hand == "right") {
                    answer += "R";
                    right = numbers[i];
                }else{
                    answer+= "L";  
                    left = numbers[i];
                } 
            }        
        }
        
        
    }
    return answer;
}