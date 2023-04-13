import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int rest;
	static int[] coin = {500,100,50,10,5,1};
	static int result;
	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		rest = 1000 - Integer.parseInt(br.readLine());
		
		for(int i=0; i<6; i++) {
			result += rest/coin[i];
			rest = rest%coin[i];
		}
		
		System.out.println(result);
	}

}