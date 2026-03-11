import java.util.*;

class Solution {
    
    public void bfs(int node, int[][] computers, boolean[] visited) {
        
        if (visited[node]) return;
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node] = true;
        
        while(!queue.isEmpty()) {
            
            int index = queue.poll();
            
            for (int i=0; i<computers[index].length; i++) {
                    
                if (index!=i && computers[index][i]==1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }

            }
            
        }
        
    }
    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int count = 0;
        boolean[] visited = new boolean[n];
    
        for (int i=0; i<n; i++) {
            
            if (!visited[i]) {
                count++;
                bfs(i, computers, visited);
            }
            
        }
        
        answer = count;
        
        return answer;
    }
}