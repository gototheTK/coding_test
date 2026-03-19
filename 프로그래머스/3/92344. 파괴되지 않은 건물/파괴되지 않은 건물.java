class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;
        
        int[][] dashboard = new int[n+1][m+1];
        
        
        for (int[] s : skill) {
            
            int type = s[0] == 1 ? -1 : 1;
            
            int r1 = s[1], c1 = s[2];
            int r2 = s[3], c2 = s[4];
            int degree = type * s[5];
            
            dashboard[r1][c1] += degree;
            dashboard[r1][c2+1] -= degree;
            dashboard[r2+1][c1] -= degree;
            dashboard[r2+1][c2+1] += degree;
            
        }
        
        for (int i=0; i<n; i++) {
            for (int j=1; j<m; j++) {
                dashboard[i][j] += dashboard[i][j-1];
            }
        }
        
        for (int j=0; j<m; j++) {
            for (int i=1; i<n; i++) {
                dashboard[i][j] += dashboard[i-1][j];
            }
        }
        
        int count = 0;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                board[i][j] += dashboard[i][j];
                if (board[i][j]>0) count++; 
            }
        }
        
        answer = count;
        
        return answer;
    }
}