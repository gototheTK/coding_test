import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        Set<String> types = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int minLen = gems.length+1;
        
        while (true) {
            
            if (window.size() == types.size()) {
                
                if (right-left<minLen) {
                    minLen = right-left;
                    answer = new int[] {left+1, right};
                }
                
                int count = window.get(gems[left])-1;
                
                if (count == 0) {
                    window.remove(gems[left]);
                }else {
                    window.put(gems[left], count);
                }
        
                left++;
            }else if(right==gems.length) {
                break;
            }else {
                int count = window.getOrDefault(gems[right], 0)+1;
                window.put(gems[right], count);
                right++;
            }
            
        }
        
        return answer;
    }
}