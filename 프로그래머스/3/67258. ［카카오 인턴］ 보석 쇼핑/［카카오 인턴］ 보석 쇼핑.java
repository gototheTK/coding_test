import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        int types = Arrays.stream(gems).collect(Collectors.toSet()).size();
        
        Map<String, Integer> selected = new HashMap<>();
        int minLen = gems.length+1;
        int left = 0;
        
        for (int right = 0; right<gems.length; right++) {
            
            selected.put(gems[right], selected.getOrDefault(gems[right], 0) + 1);
            
            while (selected.size() == types) {
                
                if (minLen > right-left) {
                    minLen = right-left;
                    answer = new int[] {left+1, right+1};
                }
                
                int count = selected.get(gems[left])-1;
                
                if (count==0) {
                    selected.remove(gems[left]);
                }else {
                    selected.put(gems[left], count);
                }
                
                left++;
                
            }
            
        }
        
        return answer;
    }
}