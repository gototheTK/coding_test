import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = (long) times[0];
        long right = (long) times[times.length-1] * n;
        
        while (left<=right) {
            
            long mid = (left + right)/2;
            long completed = 0;
            
            for (int i=0; i<times.length; i++) {
                
                completed += mid/times[i];
                
                if (completed >= n) break;
            }
            
            if (completed >= n) {
                answer = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
            
        }
        
        return answer;
    }
}