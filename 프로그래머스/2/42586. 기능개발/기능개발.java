import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Deque<Integer> progress = new ArrayDeque<>();
        Deque<Integer> speed = new ArrayDeque<>();
        
        for (int i=0; i<progresses.length; i++) {
            progress.add(progresses[i]);
            speed.add(speeds[i]);
        }
        
        List<Integer> result = new ArrayList<>();
        
        int time = 0;
        int count = 0;
        
        while (!progress.isEmpty()) {
            
            int p = progress.getFirst();
            int s = speed.getFirst();
            
            if (p + s * time >= 100) {
                progress.poll();
                speed.poll();
                count++;
            }else if(count > 0) {
                result.add(count);
                count = 0;
            }else {
                time++;
            }
            
        }
        
        result.add(count);
        
        answer = result.stream().mapToInt(Integer::valueOf).toArray();
        
        return answer;
    }
}