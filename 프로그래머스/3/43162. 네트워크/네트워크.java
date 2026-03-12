class Solution {
    
    public int find(int[] arr, int i) {
        
        if (arr[i]==i) return i;
        
        return arr[i] = find(arr, arr[i]);
    }
    
    public void union(int[] arr, int a, int b) {
        
        int rootA = find(arr, a);
        int rootB = find(arr, b);
        
        if (rootA!=rootB) {
            
            if (rootA<rootB) {
                arr[rootB] = rootA;
            }else {
                arr[rootA] = rootB;
            }
            
        }
        
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int count = 0;
        
        int[] networks = new int[n];
        
        for (int i=0; i<n; i++) {
            networks[i] = i;
        }
        
        for (int i=0; i<n; i++) {
            
            for (int j=0; j<n; j++) {
                
                if (computers[i][j]==1) {
                    union(networks, i, j);
                }
                
            }
            
        }
        
        for (int i=0; i<n; i++) {
            
            if (networks[i]==i) count++;
            
        }
        
        answer = count;
        
        return answer;
    }
}