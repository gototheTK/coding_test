import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[m][n];
        map[0][0] = 1;
        
        for (int[] puddle : puddles) {
            int i=puddle[0]-1, j=puddle[1]-1;
            map[i][j] = -1;
        }
        
        for (int i=0; i<map.length; i++) {
            
            for (int j=0; j<map[i].length; j++) {
                
                if (map[i][j]==-1) {
                    map[i][j]=0;
                    continue;
                } 
                
                if (j>0) {
                    map[i][j] += map[i][j-1];
                }
                
                if (i>0) {
                    map[i][j] += map[i-1][j];
                }
                
                map[i][j]%=1_000_000_007;
                
            }
            
        }
        
        answer = map[m-1][n-1];
        
        return answer;
    }
}