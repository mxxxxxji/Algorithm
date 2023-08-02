import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] arr;
    // 아래, 오른쪽, 위, 왼쪽
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1,0}};

    public static void main(String[] args) throws Exception{
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
        for(int i=0; i<R; i++){
            rotate();
        }

        for(int a=0; a<N; a++){
            for(int b=0; b<M; b++){
                System.out.print(arr[a][b]+" ");
            }
            System.out.println();
        }

    }
    private static void rotate(){
        int rotateNum = Math.min(N, M);

        for(int i=0; i<rotateNum/2; i++){
            int r = i; int c=i;
            int temp = arr[r][c];
            int idx = 0;
            while(idx<4){
                int nr = r + dir[idx][0];
                int nc = c + dir[idx][1];
                if(nr<N-i && nc<M-i && nr>=i && nc>=i){
                    arr[r][c] = arr[nr][nc];
                    r = nr; c = nc;
                }else {
                    idx++;
                }

            }
            arr[i+1][i] = temp;
        }
    }
}