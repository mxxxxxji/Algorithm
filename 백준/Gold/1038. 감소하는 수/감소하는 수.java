import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static ArrayList<Long> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        // 9876543210가 감소하는 수 중 가장 큰 수
        if(N<=10) System.out.println(N);
        else if(N>1022) System.out.println(-1);
        else{
            for(int i=0; i<10; i++){
                dfs(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(N));
        }
    }
    private static void dfs(long num, int depth){
        if(depth>10){
            return;
        }
        list.add(num);
        for(int i=0; i<10; i++){
            if(num%10>i){
                dfs((num*10)+i, depth+1);
            }
        }
    }
}