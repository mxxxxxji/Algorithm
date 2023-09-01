import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dx = {-1, 1};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        find(N, K);
    }
    static void find(int start, int end){
        Queue<Node> pq = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        pq.add(new Node(start, 0));
        visited[start] = true;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.x == end){
                System.out.println(cur.time);
                return;
            }
            int jump = cur.x*2;
            if(jump< 100001 && !visited[jump]) {
                visited[jump]= true;
                pq.offer(new Node(jump, cur.time));
            }
                        int back=cur.x-1;
            if(back >= 0 && back < 100001&& !visited[back]){
                visited[back]= true;
                pq.add(new Node(back, cur.time+1));
            }
            int go = cur.x+1;
            if(go >= 0 &&go < 100001 && !visited[go]){
                visited[go]= true;
                pq.add(new Node(go, cur.time+1));

            }
//            for(int i=0; i<2; i++) {
//                int next = cur.x + dx[i];
//                if (next>=0 && next <100001 && !visited[next]) {
//                    visited[next] = true;
//                    pq.add(new Node(next,cur.time+1));
//                }
//            }

        }
    }
    static class Node{
        int x;
        int time;
        public Node(int x, int time){
            this.x = x;
            this.time = time;
        }
    }
}