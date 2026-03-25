import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = (long) times[0];
        long right = (long) times[times.length-1] * n;
        
        long min = 0;
        
        while (left<=right) {   
            
            long mid = (left+right)/2;
            long completed = 0;
            
            for (int time : times) {
                completed += mid/time;
            }
            
            if (completed>=n) {
                min = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
            
        }
        
        answer = min;
        
        return answer;
    }
}