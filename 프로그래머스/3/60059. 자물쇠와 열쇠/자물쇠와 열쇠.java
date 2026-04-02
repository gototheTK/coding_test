class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        // 돌리는 로직과 일치하는 로직을 먼저 작성한다.
        // 키를 자물쇠 영억을 벗어나, 걸칠 수 있도록, n + 2 (m-1)크기의 보드를 만든다.
        // 키를 회전시키면서, (0, 0)부터 자물쇠를 위에서부터 아래로 움직여서 일치하는지 확인힌다. 이 때, 이모탭 방법을 사용한다.
        // 위를 반복하면서 일치면 true 아니면 false를 반환한다.
        
        int m = key.length;
        int n = lock.length;
        int s = n + 2 * (m-1);
        
        int[][] board = new int[s][s];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i+(m-1)][j+(m-1)] = lock[i][j];
            }
        }
        
        for (int r=0; r<4; r++) {
            
            key = rotate(key);
            
            for (int x=0; x<m-1+n; x++) {
                
                for (int y=0; y<m-1+n; y++) {
                    
                    
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
        
        return answer;
    }
    
    private int[][] rotate(int[][] arr) {
        
        int n = arr.length;
        
        int[][] result = new int[n][n];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                result[j][n-i-1] = arr[i][j];
            }
        }
        
        return result;
        
    }
    
    private boolean isMatched(int[][] board, int m, int n) {
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i+(m-1)][j+(m-1)] != 1) return false;
            }
        }
        
        return true;
        
    }
    
}