import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0]-b[0]);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        
        int count = 0;
        int index = 0;
        int time = 0;
        int periord = 0;
        
        while (count < jobs.length) {
            
            while (index<jobs.length && jobs[index][0] <= time) {
                queue.add(jobs[index]);
                index++;
            }
            
            if (queue.isEmpty()) {
                time = jobs[index][0];
            }else {
                int[] job = queue.remove();
                time += job[1];
                periord += time - job[0];
                count++;
            }
            
        }
        
        answer = periord/jobs.length;
        
        return answer;
    }
}