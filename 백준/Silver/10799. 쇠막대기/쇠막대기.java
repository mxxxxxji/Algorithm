import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> st = new Stack<>();
        String[] s = br.readLine().split("");
        for(int i=0; i<s.length; i++){
            if("(".equals(s[i])){
                st.push(s[i]);
            }else{
                st.pop();
                if("(".equals(s[i-1])){
                    answer+=st.size();
                }else{
                    answer+=1;
                }
            }


        }
        System.out.println(answer);
        // ()(
    }
}