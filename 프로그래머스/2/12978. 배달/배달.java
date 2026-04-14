import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<int[]>[] graph = new ArrayList[N+1];
        int[] dist = new int[N+1];
        
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int[] route : road) {
            
            int from = route[0];
            int to = route[1];
            int cost = route[2];
            
            graph[from].add(new int[] {to, cost});
            graph[to].add(new int[] {from, cost});
            
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        dist[1] = 0;
        pq.add(new int[] {1, dist[1]});
        
        while (!pq.isEmpty()) {
            
            int[] current = pq.poll();
            int from = current[0];
            int fromCost = current[1];
            
            if (dist[from] < fromCost) continue;
            
            for (int[] next : graph[from]) {
                
                int to = next[0];
                int toCost = fromCost + next[1];
                
                if (dist[to] > toCost) {
                    dist[to] = toCost;
                    pq.add(new int[] {to, toCost});
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