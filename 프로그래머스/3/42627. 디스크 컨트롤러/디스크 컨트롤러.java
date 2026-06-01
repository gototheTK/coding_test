import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;class Solution {

    public int solution(int[][] jobs) {

        int answer = 0;

        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));


        Queue<int[]> queue = new PriorityQueue<>((job1, job2) -> {

            if (job1[1] == job2[1]) return Integer.compare(job1[0], job2[0]);

            return Integer.compare(job1[1], job2[1]);

        });

        int index = 0;
        int time = 0;

        while (index < jobs.length || !queue.isEmpty()) {

            while (index < jobs.length && time >= jobs[index][0]) {
                queue.add(jobs[index]);
                index++;
            }

            if (queue.isEmpty()) {
                time = jobs[index][0];
                continue;
            }

            int[] job = queue.poll();
            time += job[1];
            answer += time - job[0];

        }
        
        answer/=jobs.length;

        return answer;

    }

}