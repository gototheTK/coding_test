import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        
        Queue<int[]> queue = new ArrayDeque<>();
        maps[0][0] = 0;
        queue.add(new int[]{0, 0, 1});
        
        int n = maps[0].length-1;
        int m = maps.length-1;
        
        
        while (!queue.isEmpty()) {
            
            int[] coordinate = queue.poll();
            
            int x = coordinate[0];
            int y = coordinate[1];
            int c = coordinate[2];
            
            if (x==n && y==m) return c;
            
            if (x+1 <= n && maps[y][x+1]==1) {
                maps[y][x+1] = 0;
                queue.add(new int[]{x+1, y, c+1});
            }
            
            if (y+1 <= m && maps[y+1][x]==1) {
                maps[y+1][x] = 0;
                queue.add(new int[]{x, y+1, c+1});
            }
            
            if (x-1 >= 0 && maps[y][x-1]==1) {
                maps[y][x-1] = 0;
                queue.add(new int[]{x-1, y, c+1});
            }
            
            if (y-1 >= 0 && maps[y-1][x]==1) {
                maps[y-1][x] = 0;
                queue.add(new int[]{x, y-1, c+1});
            }
            
        }
        
        return answer;
    }
}