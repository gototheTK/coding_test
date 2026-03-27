import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        
        int count = 0;
        
        while (left<=right) {
            
            int total = people[left] + people[right];
            
            if (total<=limit) {
                left++;
            }
            
            right--;
            count++;
            
        }
        
        answer = count;
        
        return answer;
    }
}