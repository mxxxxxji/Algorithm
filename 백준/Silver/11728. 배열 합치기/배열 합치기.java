import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] a;
    static int[] b;
    static int N, M;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];
        b = new int[M];

        int a_idx = 0;
        int b_idx = 0;

        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
            list.add(a[i]);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            b[i] = Integer.parseInt(st.nextToken());
            list.add(b[i]);
        }
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append(' ');
        }
        System.out.println(sb);
    }
}