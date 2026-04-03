import java.util.*;

class Solution {
    
    private int[] dijkstra(int n, int start, List<int[]>[] graph) {
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        pq.add(new int[]{start, dist[start]});
        
        while (!pq.isEmpty()) {
            
            int[] fromFare = pq.poll();
            
            int from = fromFare[0];
            int fromCost = fromFare[1];
            
            if (dist[from] < fromCost) continue;
            
            for (int[] toFare : graph[from]) {
                
                int to = toFare[0];
                int toCost = toFare[1];
                
                if (dist[to] > fromCost + toCost) {
                    dist[to] = fromCost + toCost;
                    pq.add(new int[] {to, dist[to]});
                }
                
            }
            
        }
        
        return dist;
        
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        List<int[]>[] graph = new ArrayList[n+1];
        
        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            graph[from].add(new int[]{to, cost});
            graph[to].add(new int[]{from, cost});
        }
        
        int[] distS = dijkstra(n, s, graph);
        int[] distA = dijkstra(n, a, graph);
        int[] distB = dijkstra(n, b, graph);
        
        int min = Integer.MAX_VALUE;
        
        for (int i=1; i<=n; i++) {
            
            if (distS[i] != Integer.MAX_VALUE && distA[i] != Integer.MAX_VALUE && distB[i] != Integer.MAX_VALUE) {
                min = Math.min(min, distS[i] + distA[i] + distB[i]);
            }
            
        }
        
        answer = min;
        
        return answer;
    }
}