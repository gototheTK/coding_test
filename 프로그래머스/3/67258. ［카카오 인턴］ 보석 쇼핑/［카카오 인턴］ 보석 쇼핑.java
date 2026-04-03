import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        int types = new HashSet<>(Arrays.asList(gems)).size();
        
        Map<String, Integer> typesMap = new HashMap<>();
        
        int left = 0;
        int min = gems.length+1;
        
        for (int right=0; right<gems.length; right++) {
            
            int rightCount = typesMap.getOrDefault(gems[right], 0)+1;
            typesMap.put(gems[right], rightCount);
            
            while (typesMap.size()==types) {
                
                if (min > right-left) {
                    min = right-left;
                    answer = new int[] {left+1, right+1};
                }
                
                int leftCount = typesMap.get(gems[left])-1;
                
                if(leftCount == 0) {
                    typesMap.remove(gems[left]);
                }else {
                    typesMap.put(gems[left], leftCount);
                }
                
                left++;
                
            }
            
        }
        
        return answer;
    }
}