

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static boolean[] visited;
	static ArrayList<Pos> chick; // 치킨 좌표 저장
	static ArrayList<Pos> house; // 집 좌표 저장
	static ArrayList<Pos> selected;
	
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		// 입력부입니다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken()); 
		M = Integer.parseInt(stk.nextToken()); 
		arr = new int[N][N];
		chick = new ArrayList<>();
		house = new ArrayList<>();
		selected = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
				if(arr[i][j] == 1) house.add(new Pos(i,j));
				if(arr[i][j] == 2) chick.add(new Pos(i,j));

			}
		}


		// 알고리즘 구현 시작입니다.	
		DFS(0,0);
		System.out.println(result);
	}



	private static void DFS(int index, int cnt) {
		
		if(cnt == M) {
			
			int city_dist = 0;
			
			for(int i = 0 ; i < house.size(); i++) {
				int house_dist = Integer.MAX_VALUE; // 집 하나의 치킨거리
				int hr = house.get(i).r;
				int hc = house.get(i).c;
				
				for(int j = 0 ; j < M; j++) {
					int cr = selected.get(j).r;
					int cc = selected.get(j).c;
					
					house_dist = Math.min(house_dist, Math.abs(hr-cr)+Math.abs(hc-cc));
				}
				// 도시의 치킨거리
				 city_dist += house_dist;
			}
			
			// 최소 도시의 치킨거리
			result = Math.min(result, city_dist);
		}
		for(int i = index; i < chick.size(); i++) {
			selected.add(chick.get(i));
			DFS(i+1, cnt+1);
			selected.remove(chick.get(i));
		}
	
		
	}
	
}
class Pos{
	int r;
	int c;
	public Pos (int r, int c) {
		this.r = r;
		this.c = c;
	}
}