import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0]-b[0]);
        
        for (int i=0; i<jobs.length; i++) {
            jobs[i] = new int[] {i, jobs[i][0], jobs[i][1]};
        }
        
        PriorityQueue<int[]> scheduler = new PriorityQueue<>((a, b) -> {
           
            if (a[2]==b[2]) {
                
                if (a[1]==b[1]) {
                    return a[0]-b[0];
                }
                
                return a[1]-b[1];
                
            }
            
            return a[2]-b[2];
        });
        
        int time = 0;
        int period = 0;
        int count = 0;
        int index = 0;
        
        while (count<jobs.length) {
            
            while (index<jobs.length && time>=jobs[index][1]) {
                scheduler.add(jobs[index]);
                index++;
            }
            
            if (scheduler.isEmpty()) {
                time = jobs[index][1];
            }else {
                int[] job = scheduler.poll();
                time += job[2];
                period += time - job[1];
                count++;
            }
            
        }
        
        answer = period / jobs.length;
        
        return answer;
    }
}