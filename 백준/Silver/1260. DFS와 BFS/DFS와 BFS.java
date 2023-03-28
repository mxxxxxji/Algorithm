import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int V;
	static ArrayList<Integer> arr[];
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		sb = new StringBuilder();
		
		// 초기화
		for(int i=0; i<arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		// 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i=0; i<arr.length; i++) {
			Collections.sort(arr[i]);
		}
		dfs(V);
		visited = new boolean[N+1];
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
	}
	
	public static void dfs(int index) {
		visited[index] = true;
		sb.append(index + " ");
		for(int i=0; i<arr[index].size(); i++) {
			if(!visited[arr[index].get(i)]) {
				dfs(arr[index].get(i));
			}
		}
	}
	
	public static void bfs(int index) {
		visited[index] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(index);
		
		while(!q.isEmpty()) {
			int a = q.poll();
			sb.append(a+" ");
			for(int i : arr[a]) {
				if(!visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}
}