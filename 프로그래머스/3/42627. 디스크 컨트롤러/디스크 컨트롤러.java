import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0]-b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        
        int time = 0;
        int totalTime = 0;
        int jobIndex = 0;
        int count = 0;
        
        while (count < jobs.length) {
            
            while (jobIndex<jobs.length && jobs[jobIndex][0]<=time) {
                pq.add(jobs[jobIndex]);
                jobIndex++;
            }
            
            if (pq.isEmpty()) {
                time = jobs[jobIndex][0];
            }else {
                int[] job = pq.poll();
                time += job[1];
                totalTime += time - job[0];
                count++;
            }
            
        }
        
        answer = totalTime / jobs.length;
        
        return answer;
    }
}