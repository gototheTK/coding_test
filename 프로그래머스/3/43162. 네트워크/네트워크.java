class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int count = 0;
        
        boolean[] visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            
            if (!visited[i]) {
                count++;
                dfs(computers, i, visited);
            }
            
        }
        
        answer = count;
        
        return answer;
    }
    
    public void dfs(int[][] computers, int current, boolean[] visited) {
        
        visited[current] = true;
        
        for (int i=0; i<computers[current].length; i++) {
            
            if (current != i && computers[current][i] == 1 && !visited[i]) {
                dfs(computers, i, visited);
            }
            
        }
        
    }
}