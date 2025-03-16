
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    //50-1
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] temp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(temp);
        func(n, m, temp, 0, new int[m], new boolean[n], 0);
        System.out.println(sb);
    }
    static void func(int n, int m, int[] temp, int depth, int[] arr, boolean[] visited, int start){
        if(depth == m){
            for(int num: arr){
                sb.append(num).append(' ');
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for(int i=start; i<n; i++){
            if(before==temp[i]) continue;
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = temp[i];
            before = temp[i];
            func(n, m, temp, depth+1, arr, visited, i+1);
            visited[i] = false;
        }
    }
}
