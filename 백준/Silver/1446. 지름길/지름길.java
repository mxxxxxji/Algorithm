import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, D;
    static List<Road> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 역주행 안됨
            if(e>D) continue;
            // 지름길이 아닌 경우
            if(e-s<=w) continue;
            list.add(new Road(s, e, w));
        }
        Collections.sort(list, new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                if(o1.s==o2.s) return o1.e-o1.s;
                return o1.s-o2.s;
            }
        });
        int nowIdx=0; int nowDist = 0;
        int[] dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while (nowDist < D) {
            // 어렵다
            if(nowIdx<list.size()){
                Road r = list.get(nowIdx);
                if(nowDist==r.s){
                    dist[r.e] =Math.min(dist[nowDist]+r.w, dist[r.e]);
                    nowIdx++;
                }else{
                    dist[nowDist+1] = Math.min(dist[nowDist+1], dist[nowDist]+1);
                    nowDist++;
                }
            }else{
                dist[nowDist+1] = Math.min(dist[nowDist+1], dist[nowDist]+1);
                nowDist++;
            }
        }
        System.out.println(dist[D]);
    }
    static class Road {
        int s, e, w;
        public Road(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}