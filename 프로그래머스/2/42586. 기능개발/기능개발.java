import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> result = new ArrayList<>();
        
        int index = 0;
        
        while (index < progresses.length) {
            
            for (int i=index; i<speeds.length; i++) {
                
                progresses[i] += speeds[i];
                
            }
            
            int count = 0;
            
            while (index < progresses.length
            && progresses[index] >= 100) {
                count++;
                index++;
            }
            
            if (count > 0) result.add(count);
            
        }
        
        answer = result.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}