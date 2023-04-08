import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] sw;
	public static int N, M;
	public static StringTokenizer st;
	public static BufferedReader br;
	public static void main(String[] args) throws IOException {
		// 남학생 : 스위치 번호가 자기가 받은 수의 배수이면, 스위치 상태를 바꿈
		// 여학생: 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 그 구간에 속한 스위치의 상태를 모두 바꾼다
		
		br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		sw = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			if(gender == 1) 
			{
				for(int j=number; j<=N; j+=number) {
					sw[j] = (sw[j]==0? 1:0);
				}
				
			}else {
				int l = number-1;
				int r = number+1;
				while(true) {
					if(l<1 || r>N) break;
					if(sw[l] != sw[r]) break;
					if(sw[l] == sw[r]) {
			
						sw[l] = (sw[l]==0? 1:0);
						sw[r] = (sw[r]==0? 1:0);
					
					}
					l--; r++;
				}
				sw[number] = (sw[number]==0? 1:0);
			
			}
			
		}
		for (int i = 1; i <= N; i++) {
			if(i>=20 && i % 20 == 1) System.out.println();
			System.out.print(sw[i]+" ");
		}
		br.close();
	}
}