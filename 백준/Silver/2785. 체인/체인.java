import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int cnt = 0;
        while(true){
            if(list.size()<=1) break;
            list.set(0, list.get(0)-1);
            list.remove(list.size()-1);
            if(list.get(0)==0){
                list.remove(0);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}