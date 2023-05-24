

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int n;
	static Stack<Long> st;
	static long result;
	static long max = Integer.MIN_VALUE;
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new Stack<>();
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			long x = Long.parseLong(br.readLine());
			max = Math.max(max, x);
			if(st.isEmpty()) {
				st.push(x);
			}else {
				long top = st.peek();
				if(top<x) {
					result += x-top;
					st.pop();
					st.push(x);
				}else if(top>x){
					st.pop();
					st.push(x);
				}
			}
		}
		
		while(!st.isEmpty()) {
			 long x = st.pop();
			result += max-x;
		}
		
		System.out.println(result);

	}

}
