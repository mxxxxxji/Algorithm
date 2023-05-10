
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String s = br.readLine();
			
			if(".".equals(s)) {
				bw.flush();
				return;
			}
			bw.write(checked(s));
		}
		
	}
	private static String checked(String s) {
		
		Stack<Character> st = new Stack<>();
		boolean result = true;
		
		for(int i=0; i<s.length(); i++) {
			
			char c = s.charAt(i);
			
			if(c=='(' || c=='[') {
				st.push(c);
			}else if(c ==')'){
				if(st.isEmpty() || st.pop() != '(') {
					result = false;
					break;
				}
			}else if(c == ']') {
				if(st.isEmpty() || st.pop() != '[') {
					result = false;
					break;
				}
			}
		}
		
		if(!st.isEmpty()) 
			result = false;
		
		return result? "yes\n" : "no\n";
	}
}
