import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        List<int[]>[] graph = new ArrayList[n+1];
        
        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            int from = fare[0], to = fare[1], cost = fare[2];
            
            graph[from].add(new int[]{to, cost});
            graph[to].add(new int[]{from, cost});
        }
        
        int[] distS = dijkstra(graph, n, s);
        int[] distA = dijkstra(graph, n, a);
        int[] distB = dijkstra(graph, n, b);
        
        int min = Integer.MAX_VALUE;
        
        for (int i=1; i<=n; i++) {
            
            if (distS[i] != Integer.MAX_VALUE && distA[i] != Integer.MAX_VALUE && distB[i] != Integer.MAX_VALUE) {
                min = Math.min(min, distS[i] + distA[i] + distB[i]);
            }
            
        }
        
        answer = min;
        
        return answer;
    }
    
    public int[] dijkstra(List<int[]>[] graph, int n, int start) {
        
        int[] dist = new int[n+1];
        
        for (int i=0; i<=n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        dist[start] = 0;
        pq.add(new int[]{start, dist[start]});
        
        while (!pq.isEmpty()) {
            
            int[] e1 = pq.poll();
            
            int from = e1[0];
            int fromCost = e1[1];
            
            if (dist[from] < fromCost) continue;
            
            for (int[] e2 : graph[from]) {
                
                int to = e2[0];
                int toCost = fromCost + e2[1];
                
                if (dist[to] > toCost) {
                    dist[to] = toCost;
                    pq.add(new int[]{to, toCost});
                }
                
            }
            
        }
        
        return dist;
        
    }
}