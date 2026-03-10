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

            if (rootA < rootB) {
                arr[rootB] = rootA;
            }else {
                arr[rootA] = rootB;
            }

        }

    }

    public int solution(int n, int[][] costs) {
            int answer = 0;

            int min = 0;

            Arrays.sort(costs, (n1, n2) -> n1[2]-n2[2]);

            boolean[] visited = new boolean[n];
            int[] networks = new int[n];
        
            for (int i=0; i<n; i++) {
                networks[i] = i;
            }

            for (int[] cost : costs) {
                
                int start = find(networks, cost[0]);
                int end = find(networks, cost[1]);
                
                if (start!=end) {
                    union(networks, start, end);
                    min += cost[2];
                }

            }

            answer = min;

            return answer;
    }

}