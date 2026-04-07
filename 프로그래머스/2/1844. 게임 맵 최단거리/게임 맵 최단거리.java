import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        
        int m = maps.length-1;
        int n = maps[0].length-1;
        
        Queue<int[]> queue = new ArrayDeque<>();
        maps[0][0] = 0;
        queue.add(new int[] {0, 0, 1});
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        while(!queue.isEmpty()) {
            
            int[] move = queue.poll();
            
            int x = move[0];
            int y = move[1];
            int cost = move[2];
            
            if (x==m && y==n) return cost;
            
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
            
                if (nx<=m && nx>=0 && ny<=n && ny>=0 && maps[nx][ny]==1) {
                    maps[nx][ny] = 0;
                    queue.add(new int[] {nx, ny, cost+1});
                }
                
            }
            
        }
        
        return answer;
    }
}