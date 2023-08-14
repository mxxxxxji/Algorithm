import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Time[] time;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		time = new Time[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			time[i] = new Time(start, end);

		}
		Arrays.sort(time, new Comparator<Time>(){
			@Override
			public int compare(Time t1, Time t2) {
				if(t1.e > t2.e) return 1;
				else if(t1.e==t2.e) {
					if(t1.s < t2.s) return -1;
					else return 1;
				}else {
					return-1;
				}
			}
		});
		
		int count =0;
		int prev_end_time = 0;
		for(int i=0; i<N; i++) {
			if(prev_end_time<=time[i].s) {
				prev_end_time = time[i].e;
				count++;
			}
		}
		System.out.println(count);
	}

}
class Time{
	int s;
	int e;
	public Time(int s, int e) {
		this.s = s;
		this.e = e;
	}
}