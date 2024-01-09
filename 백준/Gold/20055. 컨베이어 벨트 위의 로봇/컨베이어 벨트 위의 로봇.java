import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static boolean[] robot;
    static int step=1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[2*N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        while(true){
            rotate();
            move();
            put();
            if(check()==1) break;
            step++;
        }
        System.out.println(step);
    }
    private static void print(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<2*N; i++){
            sb.append(arr[i]+" ");
        }
        sb.append('\n');
        for(int i=0; i<2*N; i++){
            sb.append(robot[i]+" ");
        }
        sb.append('\n');
        System.out.println(sb);
    }
    private static void rotate(){
        int temp = arr[2*N-1];
        for(int i=2*N-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        for(int i=N-1; i>0; i--){
            robot[i] = robot[i-1];
        }
        robot[0] = false;

    }
    private static void move(){
        robot[N-1] = false;
        for(int i=N-1; i>0; i--){
            // 현재 위치에 로봇이 있다면 이동
            if(robot[i-1]){
                // 다음 위치에 로봇이 없고 내구도가 0보다 크다면 이동 가능
                if( !robot[i] && arr[i]>0){
                    arr[i]--; // 내구도 1감소
                    // 로봇 위치 이동
                    robot[i-1] = false;
                    robot[i] = true;
                }
            }
        }
    }
    private static void put(){
        if(arr[0]>0) {
            arr[0]--;
            robot[0] = true;
        }
    }
    private static int check(){
        int check = 0;
        for(int i=0; i<2*N; i++){
            if(arr[i]<=0) check++;
        }
        if(check>=K) return 1;
        else return 0;

    }
}