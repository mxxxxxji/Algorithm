import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int arr[][];
    static int R,C,K;
    static int rowLen, colLen;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[101][101];
        rowLen = 3;
        colLen = 3;
        for(int i=1; i<=3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        while(time<101){
            if(arr[R][C]==K) break;
            operate();
            time++;
        }
        if(time>=100 && arr[R][C]!=K) System.out.println(-1);
        else System.out.println(time);
    }
    static void operate(){
        if(rowLen>= colLen){
            for(int i=1; i<=rowLen; i++){
                calR(i);
            }
        }else{
            for(int i=1; i<=colLen; i++){
                calC(i);
            }
        }
    }
    static void calR(int idx){

        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=1; i<=colLen; i++){
            if(arr[idx][i]==0) continue;
            hs.put(arr[idx][i], hs.getOrDefault(arr[idx][i], 0)+1);
        }

        ArrayList<Pair> row = new ArrayList<>();
        for(int key : hs.keySet()){
            row.add(new Pair(key, hs.get(key)));
        }
        row.sort(Pair::compareTo);

        int i=1;
        for(Pair p : row){
            arr[idx][i++]=p.num;
            arr[idx][i++]=p.cnt;
        }
        if(colLen<i) colLen = i;
        while(i<=99){
            arr[idx][i++]=0;
            arr[idx][i++]=0;
        }

    }
    static void calC(int idx){
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i=1; i<=rowLen; i++){
            if(arr[i][idx]==0) continue;
            hs.put(arr[i][idx], hs.getOrDefault(arr[i][idx], 0)+1);
        }

        ArrayList<Pair> col = new ArrayList<>();
        for(int key : hs.keySet()){
            col.add(new Pair(key, hs.get(key)));
        }
        col.sort(Pair::compareTo);

        int i=1;
        for(Pair p : col){
            arr[i++][idx]=p.num;
            arr[i++][idx]=p.cnt;
        }
        if(rowLen<i) rowLen = i;

        while(i<=99){
            arr[i++][idx]=0;
            arr[i++][idx]=0;
        }
    }
    static class Pair{
        int num;
        int cnt;
        public Pair(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
        // cnt 기준으로 오름차순
        public int compareTo(Pair o){
            if(this.cnt>o.cnt) return 1;
            else if(this.cnt<o.cnt) return -1;
            else return this.num - o.num;
        }
    }
}