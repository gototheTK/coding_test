class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int m = key.length;
        int n = lock.length;
        
        int size = n + (m-1) * 2;
        
        int[][] board = new int[size][size];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[m-1+i][m-1+j] = lock[i][j];
            }
        }
        
        for (int r=0; r<4; r++) {
            
            board = rotate(board);
            
            for (int x=0; x<size-m+1; x++) {
                
                for (int y=0; y<size-m+1; y++) {
                    
                    for (int i=0; i<m; i++) {
                        for (int j=0; j<m; j++) {
                            board[x+i][y+j] += key[i][j];
                        }
                    }
                    
                    if (isMatched(board, m, n)) return true;
                    
                    for (int i=0; i<m; i++) {
                        for (int j=0; j<m; j++) {
                            board[x+i][y+j] -= key[i][j];
                        }
                    }
                    
                }
                
            } 
            
        }
        
        return false;
    }
    
    private int[][] rotate(int[][] board) {
        
        int s = board.length;
        int[][] result = new int[s][s];
        
        for (int i=0; i<s; i++) {
            for (int j=0; j<s; j++ ) {
                result[i][j] = board[j][s-1-i];
            }
        }
        
        return result;
        
    }
    
    private boolean isMatched(int[][] board, int m, int n) {
        
        for (int i=m-1; i<m-1+n; i++) {
            for (int j=m-1; j<m-1+n; j++) {
                if (board[i][j]!=1) return false;
            }
        }
        
        return true;
    } 
    
}