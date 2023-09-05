import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int result=0;
        while(true){
            int idx = s1.indexOf(s2);
            if(idx==-1) break;
            s1 = s1.substring(idx+s2.length());
            result++;
        }
        System.out.println(result);
    }
}