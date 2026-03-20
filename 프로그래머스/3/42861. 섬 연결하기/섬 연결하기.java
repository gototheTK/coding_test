import java.util.*;

class Solution {
    
    public int find(int[] arr, int i) {
        
        if (arr[i]==i) return i;
        
        return arr[i] = find(arr, arr[i]);
        
    }
    
    public void union(int[] arr, int a, int b) {
        
        int rootA = find(arr, a);
        int rootB = find(arr, b);
        
        if (rootA != rootB) {
            
            if (rootA<rootB) {
                arr[rootB] = rootA;
            }else {
                arr[rootA] = rootB;
            }
            
        }
        
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (a, b) -> a[2]-b[2]);
        
        int[] visited = new int[n];
        for (int i=0; i<n; i++) {
            visited[i] = i;
        }
        
        int minExpense = 0;
        
        for (int[] cost : costs) {
            
            int e1 = cost[0], e2 = cost[1];
            int expense = cost[2];
            
            if (find(visited, e1) != find(visited, e2)) {
                union(visited, e1, e2);
                minExpense += expense;
            }
            
        }
        
        answer = minExpense;
        
        return answer;
    }
}