class Solution {
    
    private void divideAndConquer(int[][] arr, int len, int x, int y, int[] result) {
        
        if (isCompressed(arr, len, x, y)) {
            result[arr[x][y]]++;
            return;
        }
        
        int half = len/2;
        
        divideAndConquer(arr, half, x, y, result);
        divideAndConquer(arr, half, x+half, y, result);
        divideAndConquer(arr, half, x, y+half, result);
        divideAndConquer(arr, half, x+half, y+half, result);
        
    }
    
    private boolean isCompressed(int[][] arr, int len, int x, int y) {
        
        int previous = arr[x][y];
        
        for (int i=x; i<len+x; i++) {
            
            for (int j=y; j<len+y; j++) {
                
                if (arr[i][j]!=previous) return false;
                
            }
            
        }
        
        return true;
        
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = {};
        
        int[] result = new int[2];
        
        divideAndConquer(arr, arr.length, 0, 0, result);
        
        answer = result;
        
        return answer;
    }
}