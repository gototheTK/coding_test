import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        /**
        
        트럭이든 공백이든 빼낸다.
        
        트럭이면, 하중을 줄인다.
        
        둘 중 뭘하든 다리의 하중을 측정하여서 트럭을 보내든, 공백을 보낸다.
        
        위를 인덱스가 끝까지 도달할 때 까지, 반복한다.
        
        인덱스의 끝에 도달하면 빼기만한다.
        
        **/
        
        Queue<Integer> bridge = new ArrayDeque<>();
        
        for (int i=0; i<bridge_length; i++) {
            bridge.add(0);
        }
        
        int time = 0;
        int index = 0;
        int totalWeight = 0;
        
        while (!bridge.isEmpty()) {

            int truck = bridge.poll();
            
            totalWeight -= truck;
            
            if (index<truck_weights.length) {
                
                if (totalWeight + truck_weights[index] <= weight) {
                    totalWeight += truck_weights[index];
                    bridge.add(truck_weights[index]);
                    index++;
                }else {
                    bridge.add(0);
                }
                
            }
            
            time++;
            
        }
        
        answer = time;
        
        
        return answer;
    }
}