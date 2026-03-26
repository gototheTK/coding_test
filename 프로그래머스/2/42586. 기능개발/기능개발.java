import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int jobs = progresses.length;
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i=0; i<jobs; i++) {
            int ceil = (100-progresses[i])%speeds[i] == 0 ? 0 : 1;
            int days = (100-progresses[i])/speeds[i] + ceil;
            queue.add(days);
        }
        
        List<Integer> dist = new ArrayList<>();
        
        int num = 1;
        int taken = queue.poll();
        
        while (!queue.isEmpty()) {
            
            int days = queue.poll();
            
            
            if (taken>=days) {
                num++;
            }else {
                dist.add(num);
                taken = days;
                num = 1;
            }
            
        }
        
        dist.add(num);
        
        answer = dist.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}