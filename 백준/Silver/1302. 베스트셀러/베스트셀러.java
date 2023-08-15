import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static HashMap<String, Integer> map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			if(map.get(name)==null) {
				map.put(name, 1);
			}else {
				map.put(name, map.get(name)+1);
			}
		}
		int cnt=0;
		String res="";
		for(String key: map.keySet()) {
			if(cnt<map.get(key)) {
				cnt = map.get(key);
				res = key;
			}else if(cnt==map.get(key)) {
				if(res.compareTo(key)>0) res = key;
			}
		}
		
		System.out.println(res);
	}

}