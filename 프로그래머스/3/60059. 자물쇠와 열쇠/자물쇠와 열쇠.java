class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int m = key.length;
        int n = lock.length;
        int s = n + 2 * (m-1);
        
        int[][] board = new int[s][s];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i+m-1][j+m-1] = lock[i][j];
            }
        }
        
        for (int r=0; r<4; r++) {
            
            key = rotate(key);
            
            for (int x=0; x<m-1+n; x++) {
                
                for (int y=0; y<m-1+n; y++) {
                    
                    for (int i=0; i<m; i++) {
                        for (int j=0; j<m; j++) {
                            board[i+x][j+y] += key[i][j];
                        }
                    }
                    
                    if (isMatched(board, m, n)) return true;
                    
                    for (int i=0; i<m; i++) {
                        for (int j=0; j<m; j++) {
                            board[i+x][j+y] -= key[i][j];
                        }
                    }
                    
                }
                
            }
            
        }
        
        return answer;
    }
    
    private int[][] rotate(int[][] arr) {
        
        int n = arr.length;
        int[][] result = new int[n][n];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                result[j][n-1-i] = arr[i][j];
            }
        }
        
        return result;
        
    }
    
    private boolean isMatched(int[][] board, int m, int n) {
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                
                if (board[i+m-1][j+m-1]!=1) return false;
                
            }
        }
        
        return true;
    }
    
}