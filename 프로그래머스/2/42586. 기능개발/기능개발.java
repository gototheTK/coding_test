import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> days = new ArrayList<>();
        
        for (int i=0; i<progresses.length; i++) {
            
            int reminder = (100-progresses[i]) % speeds[i] == 0 ? 0 : 1;
            int duration = (100-progresses[i]) / speeds[i] + reminder;
            
            days.add(duration + reminder);
            
        }
        
        List<Integer> dist = new ArrayList<>();
        
        int count = 1;
        int turnaround = days.remove(0);
        
        for (int day : days) {
            
            if (turnaround < day) {
                dist.add(count);
                turnaround = day;
                count = 1;
            }else {
                count++;
            }
            
        }
        
        dist.add(count);
        
        answer = dist.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}