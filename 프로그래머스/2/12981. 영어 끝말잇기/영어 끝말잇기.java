import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        Set<String> duplicates = new HashSet<>();
        duplicates.add(words[0]);
        
        for (int i=1; i<words.length; i++) {
            
        
            if (duplicates.contains(words[i]) || words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                
                int turn = i%n;
                int count = i/n;
                
                return new int[] {turn+1, count+1};
                
            }
            
            duplicates.add(words[i]);
            
        }

        return answer;
    }
}