import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static Info[] fish;
    static int result;
    static int[][] dir = {{-1,0}, {-1,-1}, {0,-1}, {1,-1}, {1,0}, {1,1}, {0,1}, {-1,1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[4][4];
        fish = new Info[17];


        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken())-1;
                fish[n] = new Info(n, d, i, j, 1);
                map[i][j] = n;
            }
        }
        int sr=0; int sc=0;
        int sd = fish[map[0][0]].d;
        int eat = map[0][0];
        fish[map[0][0]].alive = 0; // 상어시작 위치 물고기 죽이기
        map[0][0] = -1; // 상어 있는 위치
        dfs(sr, sc, sd, eat);
        System.out.println(result);
    }
    static void moveFish(){
        for(int i=1; i<17; i++){
            if(fish[i].alive==0) continue; // 죽은 물고기
            int cnt=0;
            int d = fish[i].d;
            int nr=0; int nc=0;
            while(cnt<8){
                d %= 8;
                fish[i].d = d; // 바뀐 방향

                // 물고기가 이동할 위치
                nr = fish[i].r + dir[d][0];
                nc = fish[i].c + dir[d][1];

                // 경계 넘거나 상어가 있을 때
                if(nr<0 || nc<0 || nr>3 || nc>3 || map[nr][nc] == -1){
                    d++; cnt++;
                    continue;
                }else{
                    if(map[nr][nc] == 0){ // 이동할 곳이 빈칸일 경우
                        map[fish[i].r][fish[i].c] = 0;
                    }else{ // 이동할 곳에 물고기가 있는 경우
                        // 바꿀곳의 물고기 -> 현재위치
                        int changeFish = fish[map[nr][nc]].n;
                        fish[changeFish].r = fish[i].r;
                        fish[changeFish].c = fish[i].c;
                        map[fish[changeFish].r][fish[changeFish].c] = changeFish;
                        // 현재위치의 물고기 -> 바꿀곳
                    }
                    fish[i].r = nr;
                    fish[i].c = nc;
                    map[nr][nc] = i;
                    break;
                }
            }
        }
    }

    static void dfs(int sr, int sc, int sd, int eat){

        // 잡아먹은 양의 최대값 구하기
        result = Math.max(result, eat);

        // map 배열 복사
        int[][] tempMap = new int[map.length][map.length];
        for(int i=0; i< tempMap.length; i++){
            for(int j=0; j< tempMap.length; j++){
                tempMap[i][j] = map[i][j];
            }
        }

        // fish 배열 복사
        Info[] tempFish = new Info[fish.length];
        for(int i=1; i<=16; i++){
            tempFish[i] = new Info(fish[i].n, fish[i].d, fish[i].r, fish[i].c, fish[i].alive);
        }

        // 물고기 이동
        moveFish();

        // 상어 이동 (1~4까지 가능)
        for(int i=1; i<4; i++){
            int nr = sr + dir[sd][0]*i;
            int nc = sc + dir[sd][1]*i;

            if(nr < 0 || nr > 3 || nc < 0 || nc > 3 || map[nr][nc] == 0) continue;
            
            int eatFish = map[nr][nc];
            int nd = fish[eatFish].d;
            map[sr][sc] = 0; // 상어가 먹은 물고기 빈 칸
            map[nr][nc] = -1; // 상어 위치
            fish[eatFish].alive = 0;

            dfs(nr, nc, nd, eat+eatFish);

            fish[eatFish].alive = 1; // 물고기 회귀
            map[sr][sc] = -1;
            map[nr][nc] = eatFish;
        }

        // map 배열 복구
        for(int i=0; i< map.length; i++){
            for(int j=0; j< map.length; j++){
                map[i][j] = tempMap[i][j];
            }
        }

        // fish 배열 복구
        for(int i=1; i<=16; i++){
            fish[i] = new Info(tempFish[i].n, tempFish[i].d, tempFish[i].r, tempFish[i].c, tempFish[i].alive);
        }
    }
}
class Info{
    int n;
    int d;
    int r;
    int c;
    int alive;
    public Info(int n, int d, int r, int c, int alive){
        this.n = n;
        this.d = d;
        this.r = r;
        this.c = c;
        this.alive = alive;
    }
}