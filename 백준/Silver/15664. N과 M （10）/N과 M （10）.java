

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 5분 35-40
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temp = new int[n];
        for(int i =0; i<n; i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(temp);
        permutation(temp,  n, m, new int[m], new boolean[n],  0, 0);
        System.out.println(sb);

    }
    static void permutation(int[] temp, int n, int m, int[] arr, boolean[] visited, int depth, int start) {
        if (depth == m) {
            for (int num : arr) {
                sb.append(num).append(' ');
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = start; i < n; i++) {
            if (before == temp[i]) continue;
            if (visited[i]) continue;
            visited[i] = true;
            arr[depth] = temp[i];
            before = temp[i];
            permutation(temp, n, m, arr, visited, depth + 1, i + 1);
            visited[i] = false;
        }
    }
}
