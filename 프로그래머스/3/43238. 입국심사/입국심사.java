import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        
        
        Arrays.sort(times);
        
        long left = (long) 1;
        long right = (long) times[times.length-1] * n;
        
        while (left<=right) {
            
            long mid = (right+left)/2;
            long count = 0;
            
            for (int i=0; i<times.length; i++) {
                count += mid/times[i];
            }
            
            if (count >= n) {
                answer = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
            
        }
        
        return answer;
    }
}