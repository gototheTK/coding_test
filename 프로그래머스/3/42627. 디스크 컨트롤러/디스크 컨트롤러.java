import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));

        Queue<int[]> heap = new PriorityQueue<>((job1, job2) -> {

            if (job1[1]==job2[1]){

                return Integer.compare(job1[0], job2[0]);

            }

            return Integer.compare(job1[1], job2[1]);

        });

        int index = 0;
        int time = 0;

        while (index < jobs.length || !heap.isEmpty()) {
            
            while (index < jobs.length && time >= jobs[index][0]) {
                heap.add(jobs[index]);
                index++;
            }
            
            if (heap.isEmpty()) {
                time = jobs[index][0];
                continue;
            }
            
            int[] job = heap.poll();
            time += job[1];
            answer += (time - job[0]);
            
        }
        
        return answer/jobs.length;

    }
}