import java.util.*;

class Solution {
   public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for (String person : participant) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }

        for (String person : completion) {

            int count = map.getOrDefault(person, 0) - 1;

            if (count <= 0) {
                map.remove(person);
            }else {
                map.put(person, count);
            }

        }

        answer = map.keySet().toArray(String[]::new)[0];

        return answer;
    }
}