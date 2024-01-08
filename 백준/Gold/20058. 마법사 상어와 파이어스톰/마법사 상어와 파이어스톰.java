import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static int[][] arr;
    static int size;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int iceSize = 0;
    static int L[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        L = new int[Q];
        size = (int)Math.pow(2, N);
        arr = new int[size][size];
        for(int i = 0; i<Math.pow(2, N); i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<Math.pow(2, N); j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++)
            L[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < Q; i++) { // Q번의 파이어스톰 실행
            fireStorm(L[i]);
        }

        // 남아있는 얼음의 합
        int sum=0;
        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                if(arr[r][c]>0) sum+=arr[r][c];
            }
        }
        System.out.println(sum);
        // 가장 큰 덩어리
        visited = new boolean[size][size];
        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                if(arr[r][c]<=0) continue;
                if(visited[r][c]) continue;
                iceSize=1;
                leftIce(r, c);
                max = Math.max(max, iceSize);
            }
        }
        if(max==Integer.MIN_VALUE) System.out.println(0);
        else System.out.println(max);
    }
    static void leftIce(int r, int c){
        visited[r][c] = true;
        for(int i=0; i<4; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if(nr<0 || nc<0 || nr>size-1 || nc>size-1) continue;
            if(arr[nr][nc]<=0) continue;
            if(visited[nr][nc]) continue;
            leftIce(nr, nc);
            iceSize++;
        }
    }
    static void fireStorm(int l){
        int partSize = (int)Math.pow(2, l); //파이어스톰 크기
        int[][] copyArr = copy(arr);
        for(int i=0; i<size; i+=partSize){
            for(int j=0; j<size; j+=partSize){
                rotate(i, j, copyArr,partSize );
            }
        }
        meltIce();
    }
    static void meltIce(){
        // 얼음이 있는 칸 3개 또는 그 이상과 인접해있지 않은 칸은 얼음의 양이 1 줄어든다.
        List<int[]> list = new ArrayList<>();
        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                int cnt = 0;
                for(int i=0; i<4; i++){
                    int nr = r + dir[i][0];
                    int nc = c + dir[i][1];

                    if(nr<0 || nc<0 || nr>size-1 || nc>size-1) continue;
                    if(arr[nr][nc]>0) cnt++;
                }
                if(cnt<3){
                    list.add(new int[]{r, c});
                }
            }
        }

        for(int i=0; i<list.size(); i++){
            int[] pos = list.get(i);
            if(arr[pos[0]][pos[1]]>=0) arr[pos[0]][pos[1]]-=1;
        }
    }
//    static void print(int[][] temp){
//        StringBuilder sb = new StringBuilder();
//        for(int r=0; r<size; r++){
//            for(int c=0; c<size; c++){
//                sb.append(temp[r][c]).append(" ");
//            }
//        sb.append('\n');
//        }
//        System.out.println(sb);
//    }
    static int[][] copy(int[][] map) {
        int data[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                data[i][j] = map[i][j];
        }
        return data;
    }
    // 90도 회전
    static void rotate(int y, int x, int[][] copy, int partSize){

        for(int r=0; r<partSize; r++){
            for(int c=0; c<partSize; c++){
                arr[y+c][x+partSize-1-r] = copy[y+r][x+c];
            }
        }

    }
}