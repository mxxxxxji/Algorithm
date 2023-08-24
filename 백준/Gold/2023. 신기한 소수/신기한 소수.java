import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[10];
        dfs(1, 0, "");
    }
    public static void dfs(int start, int depth, String s){
        if(depth==N){
            if(check(Integer.parseInt(s))) System.out.println(s);
            return;
        }
        for(int i=start; i<10; i++){
            int n = Integer.parseInt(s+i);
            if(!check(n)) continue;
            visited[i]=true;
            dfs(start, depth+1, s+i);
            visited[i]=false;
        }
    }
    public static boolean check(int num){
        //System.out.println(num);
        if(num<2) return false;
        else {
            for (int i = 2; i <= num - 1; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
}