import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] opr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        opr = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            opr[i] = Integer.parseInt(st.nextToken());
        }

        // +0 -1 *2 /3
        dfs(0, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }
    static void dfs(int depth, int value){
        if(depth==N-1){
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }
        for(int i=0; i<4; i++){
            if(opr[i]<=0) continue;
            opr[i]--;
            switch (i){
                case 0:
                    dfs(depth+1, value+arr[depth+1]);
                    break;
                case 1:
                    dfs(depth+1, value-arr[depth+1]);
                    break;
                case 2:
                    dfs(depth+1, value*arr[depth+1]);
                    break;
                case 3:
                    dfs(depth+1, value/arr[depth+1]);
                    break;
            }
            opr[i]++;
        }
    }
}