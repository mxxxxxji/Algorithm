import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    static double[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        arr = new double[N];
        for(int i=0; i<N; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if('*'==s.charAt(i)){
                double a = st.pop();
                double b = st.pop();
                st.push(b*a);
            }else if('+'==s.charAt(i)){
                double a = st.pop();
                double b = st.pop();
                st.push(b+a);
            }else if('/'==s.charAt(i)){
                double a = st.pop();
                double b = st.pop();
                st.push(b/a);
            }else if('-'==s.charAt(i)){
                double a = st.pop();
                double b = st.pop();
                st.push(b-a);
            }else{
                st.push(arr[s.charAt(i)-65]);
            }
        }
        double result = st.pop();
        System.out.printf("%.2f",result);
    }
}