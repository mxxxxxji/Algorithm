import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int cmd=0; cmd<commands.length; cmd++){
            int k = commands[cmd][2];
            int[] n = new int[commands[cmd][1]-commands[cmd][0]+1];
            for(int i=commands[cmd][0]-1; i<commands[cmd][1]; i++){
                n[i-commands[cmd][0]+1] = array[i];
            }          
            Arrays.sort(n);
            System.out.println(n[0]);
      
           answer[cmd] = n[k-1];
            
        }
        return answer;
    }
}