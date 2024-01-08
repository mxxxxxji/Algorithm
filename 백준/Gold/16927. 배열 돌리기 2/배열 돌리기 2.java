import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[][] arr;
    static int[][] temp;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int n = N;
        int m = M;
        for(int i=0; i<Math.min(N, M)/2; i++){
            rotate(i, (n-1)*2+(m-1)*2);
            n-=2;
            m-=2;
        }
        print();
    }

    private static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
               sb.append(arr[i][j]+" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    private static void rotate(int start, int r){

        int cnt = R % r;

        int num = start;
        int count = 0;
        while(count<cnt){
            int tmp = arr[num][num];
         //   System.out.println(tmp);
            // 왼쪽
            for(int i=num; i<M-1-num; i++){
                arr[num][i] = arr[num][i+1];
            }
           // print();
            // 위쪽
            for(int i=num; i<N-1-num; i++){
                arr[i][M-1-num] = arr[i+1][M-1-num];
            }
            //print();
            // 오른쪽
            for(int i=M-1-num; i>num; i--){
                arr[N-1-num][i] = arr[N-1-num][i-1];
            }
            //print();
            // 아래
            for(int i=N-1-num; i>num; i--){
                arr[i][num] = arr[i-1][num];
            }
          //  print();
            arr[num+1][num] = tmp;

            count++;
        }
    }
}