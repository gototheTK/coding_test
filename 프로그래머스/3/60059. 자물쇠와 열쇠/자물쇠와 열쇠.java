class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int m = key.length;
        int n = lock.length;
        
        int boardSize = n + (m-1)*2;
        int[][] board = new int[boardSize][boardSize];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[m-1+i][m-1+j] = lock[i][j];
            }
        }
        
        for (int r=0; r<4; r++) {
            
            key = ratate(key);
            
            for (int x=0; x<boardSize-m+1; x++) {
                
                for (int y=0; y<boardSize-m+1; y++) {
                    
                    for (int i=0; i<m; i++) {
                        for (int j=0; j<m; j++) {
                            board[x+i][y+j] += key[i][j];
                        }
                    }
                    
                    if (check(board, m, n)) {
                        return true;
                    }
                    
                    for (int i=0; i<m; i++) {
                        for (int j=0; j<m; j++) {
                            board[x+i][y+j] -= key[i][j];
                        }
                    }
                    
                    
                }
                
            }
            
        }
        
        return answer;
    }
    
    private int[][] ratate(int[][] arr) {
        
        int n = arr.length;
        
        int[][] result = new int[n][n];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                result[j][n-1-i] = arr[i][j];
            }
        }
        
        return result;
        
    }
    
    private boolean check(int[][] board, int m, int n) {
        
        for (int i=m-1; i<m-1+n; i++) {
            for (int j=m-1; j<m-1+n; j++) {
                if (board[i][j]!=1) return false;
            }
        }
        
        return true;
        
    }
    
}