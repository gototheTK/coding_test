import java.util.*;

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
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int minExpense = 0;
        
        Arrays.sort(costs, (a, b)-> a[2]-b[2]);
        
        int[] networks = new int[n];
        
        for (int i=0; i<n; i++) {
            networks[i] = i;
        }
        
        for (int[] cost : costs) {
            
            int from = cost[0];
            int to = cost[1];
            int expense = cost[2];
            
            if (find(networks, from) != find(networks, to)) {
                minExpense += expense;
                union(networks, from ,to);
            }
            
        }
        
        answer = minExpense;
        
        return answer;
    }
}