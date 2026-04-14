import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i=0; i<progresses.length; i++) {
            queue.add(new int[] {progresses[i], speeds[i]});
        }
        
        List<Integer> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            for (int i=0; i<size; i++) {
                int[] jobs = queue.poll();
                queue.add(new int[] {jobs[0] + jobs[1], jobs[1]});
            }
            
            int count = 0;
            
            for (int i=0; i<size; i++) {
                int[] jobs = queue.peek();
                
                if (jobs[0] >= 100) {
                    count++;
                    queue.poll();
                }else {
                    break;
                }
                
            }
            
            result.add(count);
            
        }
        
        answer = result.stream().mapToInt(Integer::valueOf).filter(n->n>0).toArray();
        
        return answer;
    }
}