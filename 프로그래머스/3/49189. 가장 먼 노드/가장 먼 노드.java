import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] graph = new ArrayList[n+1];
        
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            int from = e[0], to = e[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0});
        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        
        int max = 0;
        int total = 0;
        
        while (!queue.isEmpty()) {
            
            int[] e = queue.poll();
            int from = e[0];
            int count = e[1];
            
            if (max!=count) total = 0;
            
            max = Math.max(max, count);
            total++;
            
            for (int to : graph[from]) {
                
                if (visited[to]) continue;
                
                visited[to] = true;
                queue.add(new int[] {to, count+1});
            }
            
        }
        
        answer= total;
        
        return answer;
    }
}