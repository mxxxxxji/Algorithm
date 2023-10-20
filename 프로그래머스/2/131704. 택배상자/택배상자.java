import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> truck = new Stack<>();
        Stack<Integer> container = new Stack<>();
        int idx = 0;
        int box = 1;
        while(idx<order.length){ // 박스번호가 더 작다면
            if(order[idx]>box){
                container.push(box);
                box++; // 박스번호 증가

            }
            else if(order[idx] == box){ // 필요한 박스번호와 같을 때
                truck.push(box);
                idx++;
                box++;
                answer++;
            }else{ //박스 번호가 더 크다면
                if(container.isEmpty()) {
                    break;
                }
                else{ // 보조 컨테이너가 비어있지 않다면
                    if(order[idx]==container.peek()){ // 필요한 박스번호가 보조 컨테이너에 있을때
                        truck.push(container.pop()); // 보조컨테이너의 박스를 트럭에 넣음
                        answer++;
                        idx++; // 필요한 박스 번호 증가
                    }else{
                        break;
                    }
                    
                }
            }
        }
        answer = truck.size();
        return answer;
    }
}