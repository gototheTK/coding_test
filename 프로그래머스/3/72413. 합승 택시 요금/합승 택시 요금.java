import java.util.*;

class Solution {
    
    private int[] dijkstra(int n, int start, List<int[]>[] graph) {
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        pq.add(new int[] {start, 0});
        
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
        
        /**
        1. 그래프를 만든다.
            1. 그래프에 판을 만든다.
            2. 판에 각 노드들의 값들을 기입한다.
        2. 각 지점의 다익스트라 알고리즘(BFS)를 실행시킨다.
            1. 시작점부터 시작하여서, 주위의 노드들을 방문하여서, 지금까지의 비용을 계산하여서 갱신한다.
        3. s, a, b에서 시작하여서 각 지점의 최소 비용들을 구합니다.
        4. 각 지점들을 돌면서, s, a, b의 합이 최소가 되는 곳을 찾습니다.
        **/
        
        List<int[]>[] graph = new ArrayList[n+1];
        
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            
            int from = fare[0], to = fare[1], cost = fare[2];
            
            graph[from].add(new int[] {to, cost});
            graph[to].add(new int[] {from, cost});
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