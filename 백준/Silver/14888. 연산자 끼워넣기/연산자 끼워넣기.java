import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
 //       operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        // +, -, *, /
        for(int i=0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int num, int idx){
        if(idx == N){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for(int i=0; i<4; i++){
            if(operator[i]>0){
                operator[i]--;
//                switch (i) {
//
//                    case 0:
//                        dfs(num+arr[idx], idx+1); break;
//                    case 1:
//                        dfs(num-arr[idx], idx+1); break;
//                    case 2:
//                        dfs(num*arr[idx], idx+1); break;
//                    case 3:
//                        dfs(num/arr[idx], idx+1); break;
//                }
//                operator[i]++;
                if(i==0) {
                    dfs(num+arr[idx], idx+1);
                }
                else if(i==1){
                    dfs(num-arr[idx], idx+1);
                }
                else if(i==2){
                    dfs(num*arr[idx], idx+1);
                }
                else{
                    dfs(num/arr[idx], idx+1);
                }
                operator[i]++;

            }
        }
    }
}