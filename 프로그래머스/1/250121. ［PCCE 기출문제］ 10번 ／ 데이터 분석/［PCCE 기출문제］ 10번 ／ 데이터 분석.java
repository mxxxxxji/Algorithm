import java.util.*;
class Solution {
    static int target_idx,idx;
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        idx = 0;
        if("code".equals(ext))idx = 0;
        else if("date".equals(ext))idx = 1;
        else if("maximum".equals(ext))idx = 2;
        else if("remain".equals(ext))idx = 3;
        target_idx = 0;
        if("code".equals(sort_by))target_idx = 0;
        else if("date".equals(sort_by))target_idx = 1;
        else if("maximum".equals(sort_by))target_idx = 2;
        else if("remain".equals(sort_by))target_idx = 3;
        
        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<data.length; i++){
            if(data[i][idx]<val_ext){
                list.add(data[i]);
            }
        }
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[target_idx] - o2[target_idx];                
            }
        });
        
        int[][] answer = new int[list.size()][4];
        for(int i=0; i<list.size(); i++){
          
            answer[i]= list.get(i);
        
            
        }
        return answer;
    }
}