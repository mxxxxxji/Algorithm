import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            int cnt = n/5;
            for(int j=0; j<cnt; j++) System.out.print("++++ ");
        
            for(int j=0; j<n%5; j++) System.out.print("|");
            System.out.println();
        }
        
    }
}