import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String str1;
	static String str2;
	static int max;
	static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder min1 = new StringBuilder();
		StringBuilder min2 = new StringBuilder();
		StringBuilder max1 = new StringBuilder();
		StringBuilder max2 = new StringBuilder();
		
		str1 = st.nextToken();
		str2 = st.nextToken();		
	
		for(int i=0; i<str1.length(); i++){
			if(str1.charAt(i)=='5') max1.append("6");
			else max1.append(str1.charAt(i));
			if(str1.charAt(i)=='6') min1.append("5");
			else min1.append(str1.charAt(i));
		}
		
		for(int i=0; i<str2.length(); i++){
			if(str2.charAt(i)=='5') max2.append("6");
			else max2.append(str2.charAt(i));
			if(str2.charAt(i)=='6') min2.append("5");
			else min2.append(str2.charAt(i));
		}
		
		min = Integer.parseInt(min1.toString()) + Integer.parseInt(min2.toString());
		max = Integer.parseInt(max1.toString()) + Integer.parseInt(max2.toString());
		
		System.out.println(min + " "+ max);
	}

}