import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // 다리를 나타내는 큐. 다리 길이를 0(빈 공간)으로 가득 채우고 시작합니다.
        Queue<Integer> bridge = new LinkedList<>();
        
        for (int i=0; i<bridge_length; i++) {
            bridge.add(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        int index = 0;
        
        // 대기 중인 트럭이 모두 다리에 올라갈 때까지 반복합니다.
        while (index < truck_weights.length) {
            time++;
            
            // 1. 시간이 1초 흐르면, 다리 맨 앞의 공간(또는 트럭)이 무조건 빠져나갑니다.
            currentWeight -= bridge.poll();
            
            // 2. 대기 중인 다음 트럭이 올라갈 수 있는지 하중을 계산합니다.
            if (currentWeight + truck_weights[index] <= weight) {
                // 올라갈 수 있으면 트럭을 올리고 하중을 더합니다.
                bridge.add(truck_weights[index]);
                currentWeight += truck_weights[index];
                index++;
            }else {
                // 하중 때문에 못 올라가면, 빈 공간(0)을 밀어 넣어서 기존 트럭들만 전진시킵니다.
                bridge.add(0);
            }
            
        }
        
        // while문이 끝난 시점은 "마지막 트럭이 다리에 막 진입한(올라탄) 1초 뒤"입니다.
        // 마지막 트럭이 다리를 완전히 빠져나오려면 다리의 길이만큼의 시간이 더 필요합니다.
        answer = time + bridge_length;
        
        return answer;
    }
}