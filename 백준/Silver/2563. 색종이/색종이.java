import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 색종이 수
    static Pos[] arr;
    static boolean[][] paper;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new Pos[N];
        paper = new boolean[100][100];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int dx=x; dx<x+10; dx++){
                for(int dy=y; dy<y+10; dy++){
                    paper[dy][dx] = true;
                }
            }
        }
        int answer=0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(paper[i][j]) answer++;
            }
        }
        System.out.println(answer);
    }
    static class Pos {
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}