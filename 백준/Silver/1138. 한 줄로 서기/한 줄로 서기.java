import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        String s = "";
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=N; i>0; i--){
            list.add(arr[i], i);
            //            if("".equals(s)){
//                if(arr[i] == 0) s = i + s;
//                else
//            } s += i;
//            else if(arr[i] == 0) s = i + s;
//            else if("".equals(s)) s += i;
//            else {
//                int len = s.length();
//                s = s.substring(0, arr[i]) + i + s.substring(arr[i], len);
//            }
//           // System.out.println(s);
        }
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }

    }
}