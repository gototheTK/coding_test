import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b)->a[1]-b[1]);
        
        int position = routes[0][1];
        int encountered = 1;
        
        for (int[] route : routes) {
            
            int entry = route[0];
            int exit = route[1];
            
            if (entry > position) {
                position = exit;
                encountered++;
            }
            
        }
        
        answer = encountered;
        
        return answer;
    }
}