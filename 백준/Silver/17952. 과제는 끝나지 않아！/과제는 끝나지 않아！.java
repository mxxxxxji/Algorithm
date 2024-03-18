import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Stack<int[]> st = new Stack<>();
        int answer = 0;
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            if(st.isEmpty()){
                if(s.length != 1){
                    int num = Integer.parseInt(s[0]);
                    int score = Integer.parseInt(s[1]);
                    int time = Integer.parseInt(s[2]);
                    if(time-1==0) answer+=score;
                    else st.add(new int[]{num, score, time-1});
                }
            }else{
                if(s.length == 1){ // 과제가 주어지지 않음
                    int[] cur = st.pop();
                    if(cur[2]-1==0) answer+=cur[1];
                    else st.add(new int[]{cur[0], cur[1], cur[2]-1});
                }else{  // 과제가 주어짐

                    int num = Integer.parseInt(s[0]);
                    int score = Integer.parseInt(s[1]);
                    int time = Integer.parseInt(s[2]);
                    if(time-1==0) answer+=score;
                    else st.add(new int[]{num, score, time-1});
                }
            }
        }
//        int[] cur = st.pop();
//        if(cur[2]-1==0) answer+=cur[1];
//        else st.add(new int[]{cur[0], cur[1], cur[2]-1});
        System.out.println(answer);
    }
}