import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        Set<String> selected = new HashSet<>();
        
        selected.add(words[0]);
    
        for (int i=1; i<words.length; i++) {
            
            if (selected.contains(words[i]) || words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                
                int num = i%n + 1;
                int turn = i/n + 1;
                
                return new int[] {num, turn};
                
            }
            
            selected.add(words[i]);
            
        }

        return answer;
    }
}