import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        
        Map<String, String> maps = new HashMap<>();
        
        for (String str : record) {
            
            String[] strs = str.split(" ");
            
            if (strs.length > 2) {
                maps.put(strs[1], strs[2]);
            }
            
        }
        
        List<String> result = new ArrayList<>();
        
        for (String str : record) {
            
            String[] strs = str.split(" ");
            
            String name = maps.get(strs[1]);
            
            if (strs[0].equals("Enter")) {
                result.add(name + "님이 들어왔습니다.");
            }else if(strs[0].equals("Leave")) {
                result.add(name + "님이 나갔습니다.");
            }
            
        }
        
        answer = result.toArray(String[]::new);
        
        return answer;
    }
}