import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] graph = new ArrayList[n+1];
        int[] dist = new int[n+1];
        
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = -1;
        }
        
        for (int[] e : edge) {
            int from = e[0], to = e[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        
        int start = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        dist[start] = 0;
        
        int max = -1;
        
        while (!queue.isEmpty()) {
            
            int[] e = queue.poll();
            int from = e[0];
            int count = e[1];

            max = Math.max(max, count);
            
            for (int to : graph[from]) {
                
                if (dist[to]!=-1) continue;
                
                dist[to] = count+1;
                queue.add(new int[]{to, count+1});
                
            }
            
        }
        
        int count = 0;
        
        for (int i=0; i<dist.length; i++) {
            
            if (max==dist[i]) count++;
            
        }
        
        answer = count;
        
        return answer;
    }
}