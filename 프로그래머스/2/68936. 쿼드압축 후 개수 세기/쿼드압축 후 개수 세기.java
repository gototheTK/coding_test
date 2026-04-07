class Solution {
    
    private void divideAndConquer(int[][] arr, int size, int x, int y, int[] result) {
        
        if (isCompressed(arr, size, x, y)) {
            result[arr[x][y]]++;
            return;
        }
        
        int half = size/2;
        
        divideAndConquer(arr, half, x, y, result);
        divideAndConquer(arr, half, x+half, y, result);
        divideAndConquer(arr, half, x, y+half, result);
        divideAndConquer(arr, half, x+half, y+half, result);
    }
    
    private boolean isCompressed(int[][] arr, int size, int x, int y) {
        
        int previous = arr[x][y];
        
        for (int i=x; i<size+x; i++) {
            for (int j=y; j<size+y; j++) {
                if (arr[i][j]!=previous) return false;
            }
        }
        
        return true;
        
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = {};
        
        /**
        1. 배열의 길이의 절반이루어진 사각형을 검사한다.
        2. 전부 같은 숫자면, 0, 1의 개수를 올린다.
        3. 사격형의 길이의 절반을 구해서, 그 길이 만큼의 사각형들을 검사한다.
        4. 전부 같은 숫잔 내지는 길이가 1일 때 까지 위를 반복한다.
        */
        
        int[] result = new int[2];
        
        divideAndConquer(arr, arr.length, 0, 0, result);
        
        answer = result;
        
        return answer;
    }
}