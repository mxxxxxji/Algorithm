import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int C;
	static int[] house;

	static int min;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		
		house = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		// 정렬
		Arrays.sort(house);
		
		// 집 사이의 최소 거리 :1
		// 집 사이의 최대 거리 :마지막 집 - 첫 집
		min = 1;
		max = house[N-1]-house[0];
		
		int res = 0;
		
		
		//거리를 기준으로 이분탐색
		while(min <= max) {
			
			int mid = (min+max)/2;
			
			int cnt = findCountWifi(mid);
			
			if(cnt < C) {
				max = mid - 1;
			}else {
				res = mid;
				min = mid + 1;
				
			}
			
		}
		
		System.out.println(res);

	}

	private static int findCountWifi(int mid) {
		
		int cnt = 1;
		int LL = house[0]; // Last Location : 마지막으로 설치한 집
		
		for(int i = 1 ; i < N ; i++) {
			int CL = house[i];// Current Location : 현재 위치
			if(CL - LL >= mid) {
				cnt++;
				LL = CL;
			}
		}
		return cnt;
	}

}