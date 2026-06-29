import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        maps[0][0] = 0;
        queue.add(new int[]{0, 0, 1});
        
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        while (!queue.isEmpty()) {
            
            int[] coordinate = queue.poll();
            
            int x = coordinate[0];
            int y = coordinate[1];
            int c = coordinate[2];
            
            if (x == maps.length-1 && y == maps[0].length-1) return c;
            
            for (int[] direction : directions) {
                
                int nextX = x + direction[0];
                int nextY = y + direction[1];
                
                if (nextX >= 0 && nextX < maps.length
                && nextY >= 0 && nextY < maps[0].length
                && maps[nextX][nextY] == 1) {
                    queue.add(new int[]{nextX, nextY, c+1});
                    maps[nextX][nextY] = 0;
                }
                
            }
            
        }
        
        return -1;
    }
}