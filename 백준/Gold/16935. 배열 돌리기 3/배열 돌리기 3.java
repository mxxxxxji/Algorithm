import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] array;
    static int[] CMD;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        array = new int[N][M];
        CMD = new int[R];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<R; i++){
            CMD[i] = Integer.parseInt(st.nextToken());
        }
        int[][] answer = array;
        for(int i=0; i<R; i++){
            switch (CMD[i]){
                case 1: // 상하반전
                    answer = reverse1(answer);
                    break;
                case 2: // 좌우반전
                    answer = reverse2(answer);
                    break;
                case 3: // 오른쪽 90도 회전
                    answer = rightRotate(answer);
                    break;
                case 4: // 왼쪽 90도 회전
                    answer = leftRotate(answer);
                    break;
                case 5: // part1
                    answer = partRightRotate(answer);
                    break;
                case 6: // part2
                    answer = partLeftRotate(answer);
                    break;
            }

        }
        print(answer);

    }
    private static void print(int[][] tmp){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<tmp.length; i++){
            for(int j=0; j<tmp[i].length; j++){
                sb.append(tmp[i][j]+" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    private static int[][] reverse1(int[][] arr){
         int n = arr.length;
         int m = arr[0].length;
         int[][] tmp = new int[n][m];
         for(int i=0; i<n; i++){
             for(int j=0; j<m; j++){
                 tmp[n-i-1][j] = arr[i][j];
             }
         }
        return tmp;
    }
    private static int[][] reverse2(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] tmp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tmp[i][m-j-1] = arr[i][j];
            }
        }
        return tmp;
    }
    private static int[][] rightRotate(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] tmp = new int[m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tmp[j][n-i-1] = arr[i][j];
            }
        }
        return tmp;
    }
    private static int[][] leftRotate(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] tmp = new int[m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tmp[m-j-1][i] = arr[i][j];
            }
        }
        return tmp;
    }
    private static int[][] partRightRotate(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] tmp = new int[n][m];
        int partN = n/2;
        int partM = m/2;
        // 1->2
        for(int i=0; i<partN; i++){
            for(int j=partM; j<m; j++){
                tmp[i][j] = arr[i][j-partM];
            }
        }
        // 2->3
        for(int i=partN; i<n; i++){
            for(int j=partM; j<m; j++){
                tmp[i][j] = arr[i-partN][j];
            }
        }
        // 3->4
        for(int i=partN; i<n; i++){
            for(int j=0; j<partM; j++){
                tmp[i][j] = arr[i][j+partM];
            }
        }
        // 4->1
        for(int i=0; i<partN; i++){
            for(int j=0; j<partM; j++){
                tmp[i][j] = arr[i+partN][j];
            }
        }
        return tmp;
    }
    private static int[][] partLeftRotate(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] tmp = new int[n][m];
        int partN = n/2;
        int partM = m/2;

        // 2->1
        for(int i=0; i<partN; i++){
            for(int j=0; j<partM; j++){
                tmp[i][j] = arr[i][j+partM];
            }
        }
        // 3->2
        for(int i=0; i<partN; i++){
            for(int j=partM; j<m; j++){
                tmp[i][j] = arr[i+partN][j];
            }
        }
        // 4->3
        for(int i=partN; i<n; i++){
            for(int j=partM; j<m; j++){
                tmp[i][j] = arr[i][j-partM];
            }
        }
        // 1->4
        for(int i=partN; i<n; i++){
            for(int j=0; j<partM; j++){
                tmp[i][j] = arr[i-partN][j];
            }
        }
        return tmp;
    }
}