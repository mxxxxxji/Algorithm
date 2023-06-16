package SOFTEER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전광판
public class SOFT624 {

	static int[][] number = {{1,1,1,0,1,1,1},//0
							{0,0,1,0,0,1,0},//1
							{1,0,1,1,1,0,1},//2
							{1,0,1,1,0,1,1},//3
							{0,1,1,1,0,1,0},//4
							{1,1,0,1,0,1,1},//5
							{1,1,0,1,1,1,1},//6
							{1,1,1,0,0,1,0},//7
							{1,1,1,1,1,1,1},//8
							{1,1,1,1,0,1,1}};//9
	static int T;
	static String A, B;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			A = st.nextToken();
			B = st.nextToken();
			int alen = A.length()-1;
			int blen = B.length()-1;
			answer = 0;
			while(true) {
				
				if(alen<0 && blen<0) break;
				else if(alen>=0 && blen>=0) {
					int a = A.charAt(alen) - '0';
					int b = B.charAt(blen) - '0';
					for(int j=0; j<7; j++) {
						if(number[a][j] != number[b][j]) answer++;
					}
				}else if(alen<0) {
					int b = B.charAt(blen) - '0';
					for(int j=0; j<7; j++) {
						if(number[b][j]!=0) answer++;
					}
				}else if(blen<0) {
					int a = A.charAt(alen) - '0';
					for(int j=0; j<7; j++) {
						if(number[a][j]!=0) answer++;
					}
				}
				alen--;
				blen--;
			}
			System.out.println(answer);
		}
	}
}
