import java.util.*;

class Solution {
    
    private int[] dijkstra(int n, int start, List<int[]>[] graph) {
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        boolean[] visited = new boolean[n+1];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        dist[start] = 0;
        pq.add(new int[]{start, dist[start]});
        
        while(!pq.isEmpty()) {
            
            int[] way = pq.poll();
            
            int from = way[0];
            int fromCost = way[1];
            
            if (fromCost>dist[from]) continue;
            
            for (int[] route : graph[from]) {
                
                int to = route[0];
                int toCost = route[1];
                
                int cost = fromCost + toCost;
                
                if (dist[to] > cost) {
                    dist[to] = cost;
                    pq.add(new int[] {to, cost});
                }
                
            }
            
        }
        
        return dist;
        
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        /**
        그래프를 만든다.
        S, A, B에서 시작하여 다익스트라를 구한다.
        S + A + B의 합이 최소가 되는 지점의 합을 구한다.
        **/
        
        List<int[]>[] graph = new ArrayList[n+1];
        
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int cost = fare[2];
            
            graph[start].add(new int[]{end, cost});
            graph[end].add(new int[]{start, cost});
        }
        
        int[] distS = dijkstra(n, s, graph);
        int[] distA = dijkstra(n, a, graph);
        int[] distB = dijkstra(n, b, graph);
        
        int min = Integer.MAX_VALUE;
        
        for (int i=1; i<=n; i++) {
            
            if (distS[i]!=Integer.MAX_VALUE && distA[i]!=Integer.MAX_VALUE && distB[i]!=Integer.MAX_VALUE) {
                min = Math.min(min, distS[i] + distA[i] + distB[i]);
            }
            
        }
        
        answer = min;
        
        return answer;
    }
}