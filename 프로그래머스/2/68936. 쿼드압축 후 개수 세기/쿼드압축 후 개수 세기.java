import java.util.*;

class Solution {
    
    public void divideAndConquer(int[][] arr, int len, int x, int y, List<Integer> result) {
        
        if (isCompressed(arr, len, x, y)) {
            result.add(arr[x][y]);
            return;
        }
        
        if (len==1) {
            result.add(arr[x][y]);
            return;
        }
        
        divideAndConquer(arr, len/2, x, y, result);
        divideAndConquer(arr, len/2, x + len/2, y, result);
        divideAndConquer(arr, len/2, x, y + len/2, result);
        divideAndConquer(arr, len/2, x + len/2, y + len/2, result);
        
    }
    
    private boolean isCompressed (int[][] arr, int len, int x, int y) {
        
        int previous = arr[x][y];
        
        for (int i=x; i<len+x; i++) {
            
            for (int j=y; j<len+y; j++) {
                
                if (arr[i][j]!=previous) {
                    return false;
                }
                
            }
            
        }
        
        return true;
        
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = {};
        
        /**
        행의 길이와 압축 카운트를 구한다.
        압축 카운트에 따른 행의 길이를 줄인다.
        len -> len/2
        count -> count++;
        
        압축한 사각형의 0과 1의 개수를 구한다.
        모두 0이나 1이면 그 수 단하나만 반환한다.
        
        아니면 계속 사각형을 나눈다.
        
        **/
        
        List<Integer> result = new ArrayList<>();
        
        divideAndConquer(arr, arr.length, 0, 0, result);
        
        int count0 = 0;
        int count1 = 0;
        
        for (int num : result) {
            if (num == 0) count0++;
            if (num == 1) count1++;
        }
        
        answer = new int[] {count0, count1};
        
        return answer;
    }
}