import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        /**
        
        처음부터 시작하여서, 범위를 모든 보석을 찾을 때까지 늘려간다.
        모든 보석을 찾았으면, 시작부분을 증가시키고, 다시 모든 보석을 찾을 때 까지 늘려간다.
        끝부분이 마지막까지 닿을 때까지 반복한다.
        그러기 위해서는, 모든 종류의 보석의 개수를 구해야 한다.
        
        **/
        
        int types = Arrays.stream(gems).collect(Collectors.toSet()).size();
        
        Map<String, Integer> typesMap = new HashMap<>();
        
        int left = 0;
        int minLen = gems.length+1;
        
        for (int right=0; right<gems.length; right++) {
            
            int rightCount = typesMap.getOrDefault(gems[right], 0) + 1;
            typesMap.put(gems[right], rightCount);
            
            while (typesMap.size() == types) {
                
                if (minLen > right-left) {
                    minLen = right-left;
                    answer = new int[] {left+1, right+1};
                }
                
                int leftCount = typesMap.getOrDefault(gems[left], 0) - 1;
                
                if (leftCount == 0) {
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