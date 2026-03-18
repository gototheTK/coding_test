import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        Set<String> types = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> window = new HashMap<>();
        
        int left = 0;
        int minLen = gems.length+1;
        
        for (int right = 0; right<gems.length; right++) {
            
            window.put(gems[right], window.getOrDefault(gems[right], 0) + 1);
            
            while (window.size()==types.size()) {
                
                if (right-left<minLen) {
                    minLen = right-left;
                    answer = new int[] {left+1, right+1};
                }
                
                int count = window.get(gems[left])-1;
                
                if (count<=0) {
                    window.remove(gems[left]);
                }else {
                    window.put(gems[left], count);
                }
                
                left++;
                
            }
            
        }
        
        return answer;
    }
}