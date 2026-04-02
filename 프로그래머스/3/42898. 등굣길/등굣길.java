class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        /**
        1. m x n의 보드을 만든다.
        2. 보드에 물칸을 넣는데, -1을 넣는다.
        3. (0,0)부터 시작해서, 한칸 한칸 갈 때 마다, 왼쪽칸과 윗쪽칸의 수를 더한다.
        4. -1을 만날 때는, 0을 넣는다.
        5. 도착점에 도착할 때 까지, 3,4를 반복한다.
        **/
        
        int[][] board = new int[n][m];
        board[0][0] = 1;
        
        for (int[] puddle : puddles) {
            
            int i = puddle[1]-1;
            int j = puddle[0]-1;
            
            board[i][j] = -1;
            
        }
        
        for (int i=0; i<n; i++) {
            
            for (int j=0; j<m; j++) {
                
                if (i==0 && j==0) continue;
                
                if (board[i][j]==-1) {
                    board[i][j] = 0;
                    continue;
                }
                
                if (i-1<0) {
                    board[i][j] += board[i][j-1];
                }else if (j-1<0) {
                    board[i][j] += board[i-1][j];
                }else {
                    board[i][j] += board[i][j-1] + board[i-1][j];
                }
                
                board[i][j] %= 1_000_000_007;
                
            }
            
        }
        
        answer = board[n-1][m-1];
        
        return answer;
    }
}