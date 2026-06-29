class Solution {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
            
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, boolean[] visited, int start) {
        
        if (visited[start]) return;
        
        visited[start] = true;
        
        for (int i=0; i<computers[start].length; i++) {
            
            if (i != start && computers[start][i]==1) {
                dfs(computers, visited, i);
            }
            
        }
        
    }
    
}