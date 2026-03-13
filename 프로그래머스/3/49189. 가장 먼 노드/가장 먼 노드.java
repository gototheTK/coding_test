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
        
        int start = 1;
        int[] away = new int[n+1];
        
        for (int i=0; i<away.length; i++) {
            away[i] = -1;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        away[start] = 0;
        
        int max = away[start];
        
        while(!queue.isEmpty()) {
            
            int from = queue.poll();
            max = Math.max(max, away[from]);
            
            for (int to : graph[from]) {
                
                if (away[to]!=-1) continue;
                
                away[to] = away[from]+1;
                queue.add(to);
                
            }
            
        }
        
        int count = 0;
        for (int i=0; i<away.length; i++) {
            if (max==away[i]) count++;
        }
        answer = count;
        
        return answer;
    }
}