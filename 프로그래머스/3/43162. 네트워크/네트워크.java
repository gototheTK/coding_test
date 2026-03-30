class Solution {
    
    private int find(int[] arr, int i) {
        
        if (arr[i]==i) return i;
        
        return arr[i] = find(arr, arr[i]);
        
    }
    
    private void union(int[] arr, int a, int b) {
        
        int rootA = find(arr, a);
        int rootB = find(arr, b);
        
        if (rootA != rootB) {
            
            if (rootA < rootB) {
                arr[rootB] = rootA;  
            }else {
                arr[rootA] = rootB;
            }
            
        }
        
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int count = n;
        int[] group = new int[n];
        
        for (int i=0; i<n; i++) {
            group[i] = i;
        }
        
        for (int i=0; i<n; i++) {
            
            for (int j=0; j<n; j++) {
                
                if (find(group, i) != find(group, j) && computers[i][j]==1) {
                    union(group, i, j);
                    count--;
                }
                
            }
            
        }
        
        answer = count;
        
        return answer;
    }
}