import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        
        
        //StringBuilder sb = new StringBuilder();
        List<Point> list = new ArrayList<>();
        for(int i=0; i<line.length; i++){
            for(int j=i+1; j<line.length; j++){
                Point p = func(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                
                if(p != null) {
                    list.add(p);
                    //System.out.println(p.y+", "+p.x);
                }
            }
        }
        Point maxP = findMaxPoint(list);
        Point minP = findMinPoint(list);
        
        //sb.append(maxP.y + ", " + maxP.x);
        //sb.append(minP.y + ", " + minP.y);
        
        //System.out.println(sb);
        
        int h = (int)(maxP.y - minP.y)+1;
        int w = (int)(maxP.x - minP.x)+1;
        
        String[] answer = new String[h];
        int idx=0;
        
        for(int i=0; i<h; i++){
            answer[i] = "";
            for(int j=0; j<w; j++){
                answer[i] += ".";
            }
            
        }
        
        for(Point p : list){
            int px = (int)(p.x - minP.x);
            int py = (int)(maxP.y - p.y);

            StringBuilder sb = new StringBuilder(answer[py]);
            sb.setCharAt(px, '*');           
            answer[py] = sb.toString();      
        }
        
        
        return answer;
    }
    private Point findMaxPoint(List<Point> list){
        long maxY = Long.MIN_VALUE;
        long maxX = Long.MIN_VALUE;

        for(Point p: list){
            if(maxY < p.y) maxY = p.y;
            if(maxX < p.x) maxX = p.x;
        }
        return new Point(maxY, maxX);
    }
    private Point findMinPoint(List<Point> list){
        long minY = Long.MAX_VALUE;
        long minX = Long.MAX_VALUE;
        for(Point p: list){
            if(minY > p.y) minY = p.y;
            if(minX > p.x) minX = p.x;
        }
        return new Point(minY, minX);
    }

    private Point func(long a, long b, long e, long c, long d, long f){
      
        if(a*d - b*c == 0) return null;
        
        double x = (double)(b*f-e*d)/(a*d-b*c);
        double y = (double)(e*c-a*f)/(a*d-b*c);
    
        if(x%1 != 0 || y%1 != 0) return null;
        
        return new Point((long)y, (long)x);
    }
    private static class Point {
        public final long y;
        public final long x;
        private Point(long y, long x){
            this.y = y;
            this.x = x;
        }
    }
}
