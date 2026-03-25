import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        
        PriorityQueue<int[]> tasks = new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        int time = 0;
        int completed = 0;
        int index = 0;
        int turnaroundTime = 0;
        
        while (completed < jobs.length) {
            
            while (index<jobs.length && jobs[index][0] <= time) {
                tasks.add(jobs[index]);
                index++;
            }
            
            if (tasks.isEmpty()) {
                time = jobs[index][0];
            }else {
                int[] job = tasks.remove();
                time += job[1];
                turnaroundTime += time - job[0];
                completed++;
            }
            
        }
        
        answer = turnaroundTime/jobs.length;
        
        return answer;
    }
}