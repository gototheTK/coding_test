import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        /**
        진출시간이 짧은 순으로 정렬한다.
        차량들을 하나씩 꺼내어서, 전의 진출시간보다 진입시간이 낮은 것들은 넘어가고, 진출 시간이 큰 것이 나오면 비교시간을 갱신한다. 그리고 +1을 한다.
        **/
        
        Arrays.sort(routes, (a,b)->a[1]-b[1]);
        
        int camera = 1;
        int position = routes[0][1];
        
        for (int[] route : routes) {
            
            int entry = route[0], exit = route[1];
            
            if (entry>position) {
                position = exit;
                camera++;
            }
            
        }
        
        answer = camera;
        
        return answer;
    }
}