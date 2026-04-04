import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<int[]>[] graph = new ArrayList[N+1];
        
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] route : road) {
            
            int start = route[0];
            int end = route[1];
            int cost = route[2];
            
            graph[start].add(new int[]{end, cost});
            graph[end].add(new int[]{start, cost});
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        dist[1] = 1;
        queue.add(new int[]{1, 0});
        
        while (!queue.isEmpty()) {
            
            int[] current = queue.poll();
            
            int start = current[0];
            int currentCost = current[1];
            
            if (currentCost > dist[start]) continue;
            
            for (int[] next : graph[start]) {
                
                int end = next[0];
                int nextCost = next[1];
                
                int total = currentCost+nextCost;
                
                
                if (dist[end] > total) {
                    dist[end] = total;
                    queue.add(new int[]{end, total});
                }
                
            }
            
        }
        
        int count = 0;
        for (int i=1; i<=N; i++) {
            
            if (dist[i]<=K) count++;
            
        }
        
        answer = count;

        return answer;
    }
}