import java.util.*;

class Solution {
    
    public void dfs(Map<String, List<String>> tickets, String from, List<String> result) {
        
        while (tickets.containsKey(from) && !tickets.get(from).isEmpty()) {
            dfs (tickets, tickets.get(from).remove(0), result);
        }

        result.add(0, from);

    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        Map<String, List<String>> maps = new HashMap<>();

        for (String[] ticket : tickets) {
            maps.computeIfAbsent(ticket[0], key -> new LinkedList<>()).add(ticket[1]);
        }

        maps.entrySet().forEach(entry -> entry.getValue().sort(Comparator.naturalOrder()));

        List<String> result = new LinkedList<>();

        dfs(maps, "ICN", result);

        answer = result.toArray(String[]::new);

        return answer;
    }
    
}