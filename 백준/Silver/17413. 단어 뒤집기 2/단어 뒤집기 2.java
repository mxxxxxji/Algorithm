import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder answer = new StringBuilder();

        Stack<Character> st = new Stack<>();
        boolean tag = false;
        StringBuilder word = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='<'){// 태그의 머리일 경우
                tag = true;
                // 스택이 비어있지 않다면 앞의 문자를 pop()
                while(!st.empty()) answer.append(st.pop());
                // 비어있다면 첫 태그
                answer.append(str.charAt(i));
            }else if(str.charAt(i)=='>'){
                // 태그가 끝났으므로
                tag = false;
                answer.append(str.charAt(i));
            }else if(str.charAt(i)==' '){
                if(!tag){
                    while(!st.empty()) answer.append(st.pop());
                }
                answer.append(str.charAt(i));
            }else{
                if(!tag) {
                    st.push(str.charAt(i));
                }else{
                    answer.append(str.charAt(i));
                }

            }

        }
        while(!st.empty()){
            answer.append(st.pop());
        }

        System.out.println(answer);
    }
}