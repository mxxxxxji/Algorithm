import java.util.*;
class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static int count;
    public int solution(String word) {
        int answer = 0;
        dfs("", 0);
        answer = map.get(word);
        return answer;
    }
    static void dfs(String str, int depth){
        map.put(str, count++);
        if(depth==5) return;
        dfs(str + "A", depth+1);
        dfs(str + "E", depth+1);
        dfs(str + "I", depth+1);
        dfs(str + "O", depth+1);
        dfs(str + "U", depth+1);
    }
}