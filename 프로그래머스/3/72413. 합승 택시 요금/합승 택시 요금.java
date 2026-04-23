import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        /**
        다익스트라를 적용해야한다.
        1. A,B,S를 제외한 점 중에서 A, B, S에서 시작해서 가장 적은 비용의 경로를 구합니다.
        2. 위에서 구한 가장 적은 비용의 합중에서 가장 작은 값을 구해서 리턴합니다.
        **/
        
        List<int[]>[] graph = new ArrayList[n+1];
        
        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            graph[from].add(new int[] {to, cost});
            graph[to].add(new int[] {from, cost});
            
        }
        
       int[] distS = dijkstra(graph, n, s);
       int[] distA = dijkstra(graph, n, a);
       int[] distB = dijkstra(graph, n, b);
        
        int min = Integer.MAX_VALUE;
        
        for (int i=1; i<=n; i++) {
            
            if (distS[i]!=Integer.MAX_VALUE 
                && distA[i]!=Integer.MAX_VALUE 
                && distB[i]!=Integer.MAX_VALUE) {
                
                min = Math.min(min, distS[i] + distA[i] + distB[i]);
                
            }
            
        }
        
        answer = min;
        
        return answer;
    }
    
    private int[] dijkstra (List<int[]>[] graph, int n, int from) {
        
        int[] dist = new int[n+1];
        
        for (int i=0; i<=n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        dist[from] = 0;
        pq.add(new int[] {from, 0});
        
        while (!pq.isEmpty()) {
            
            int[] e1 = pq.poll();
            
            int current = e1[0];
            int currentCost = e1[1];
            
            if (currentCost > dist[current]) continue;
            
            for (int[] e2 : graph[current]) {
                
                int next = e2[0];
                int nextCost = currentCost + e2[1];
                
                if (dist[next] > nextCost) {
                    dist[current] = currentCost;
                    pq.add(new int[] {next, nextCost});
                }   
                
            }
            
        }
        
        return dist;
        
    } 
    
}