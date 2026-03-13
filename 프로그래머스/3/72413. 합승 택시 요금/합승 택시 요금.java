import java.util.*;

class Solution {
    
    public int[] dijkstra(int n, int start, List<int[]>[] graph) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        pq.add(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curNode = current[0];
            int curCost = current[1];
            
            if (curCost > dist[curNode]) continue;
            
            for (int[] edge : graph[curNode]) {
                int nextNode = edge[0];
                int nextCost = edge[1];
                
                if (dist[nextNode] > curCost + nextCost) {
                    dist[nextNode] = curCost + nextCost;
                    pq.add(new int[] {nextNode, dist[nextNode]});
                }
            }
            
        }
        
        return dist;
        
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        List<int[]>[] graph = new ArrayList[n+1];
        
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            int from = fare[0], to = fare[1], cost = fare[2];
            graph[from].add(new int[]{to, cost});
            graph[to].add(new int[]{from, cost});
        }
        
        int[] distS = dijkstra(n, s, graph);
        int[] distA = dijkstra(n, a, graph);
        int[] distB = dijkstra(n, b, graph);
        
        answer = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            if (distS[i] != Integer.MAX_VALUE && distA[i] != Integer.MAX_VALUE && distB[i] != Integer.MAX_VALUE) {
                answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
            }
        }
        
        return answer;
    }
}