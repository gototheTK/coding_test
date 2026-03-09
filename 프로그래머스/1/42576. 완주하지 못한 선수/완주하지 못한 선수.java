import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> participants = new HashMap<>();
        
        for (String person : participant) {
            participants.put(person, participants.getOrDefault(person, 0)+1);
        }
        
        for (String person : completion) {
            int count = participants.getOrDefault(person, 0)-1;
            
            if (count<=0) {
                participants.remove(person);
            }else {
                participants.put(person, count);
            }
        }
        
        answer = new ArrayList<>(participants.keySet()).get(0);
        
        return answer;
    }
}