class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[m][n];
        map[0][0] = 1;
        
        for (int[] puddle : puddles) {
            int x = puddle[0]-1, y = puddle[1]-1;
            map[x][y] = -1;
        }
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                
                if (map[i][j]==-1) {
                    map[i][j] = 0;
                    continue;
                }
                
                if (i>0) {
                    map[i][j] += map[i-1][j];
                }
                
                map[i][j] %= 1000_000_007;
                
                if (j>0) {
                    map[i][j] += map[i][j-1];
                }
                
                map[i][j] %= 1000_000_007;
                
            }
        }
        
        answer = map[m-1][n-1];
         
        return answer;
    }
}