import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] res;
    static String[] str;
    static boolean[] visited;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    static String max_str="";
    static String min_str="";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        str = br.readLine().split(" ");

        res = new int[K+1];
       // for(int i=0; i<10; i++){
           // if(visited[i]) continue;
            visited = new boolean[10];
            dfs(0, 0);
      //  }
        System.out.println(max_str);
        System.out.println(min_str);
    }
    static void dfs(int start, int depth){
        if(depth==K+1){
            String s = "";
            for(int i=0; i<res.length; i++){
                s += res[i];
              //    System.out.print(res[i]+" ");
            }

            long num = Long.parseLong(s);

            if(num>max){
                max = num; max_str = s;
            }
            if(num<min) {
                min = num; min_str = s;
            }
            return;
        }
        for(int i=0; i<10; i++){
            if(visited[i]) continue;
            if(depth==0) {
                visited[i] = true;
                res[depth] = arr[i];
                dfs(i+1, depth+1);
                visited[i] = false;
            }else{
                //System.out.println(str[depth-1]);
                switch (str[depth-1]){
                    case "<":
                        if(res[depth-1]<arr[i]) {
                         //   System.out.println(res[depth-1]+" "+arr[i]);
                            visited[i] = true;
                            res[depth] = arr[i];
                            dfs(i+1, depth+1);
                            visited[i] = false;
                        }
                        break;
                    case">":
                        if(res[depth-1]>arr[i]) {
                          //  System.out.println(res[depth-1]+" "+arr[i]);
                            visited[i] = true;
                            res[depth] = arr[i];
                            dfs(i+1, depth+1);
                            visited[i] = false;
                        }
                        break;
                }
            }


        }
    }
}