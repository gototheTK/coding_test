import java.util.*;

class Solution {
    
    public static class Word {
        
        String word;
        int change;
        
        public Word(String word, int change) {
            this.word = word;
            this.change = change;
        }
        
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<Word> queue = new ArrayDeque<>();
        queue.add(new Word(begin, 0));
        
        Set<String> selected = new HashSet<>();
        
        while (!queue.isEmpty()) {
            
            Word word = queue.poll();
            
            String current = word.word;
            int change = word.change;
            
            if (target.equals(current)) return change;
            
            for (String next : words) {
                
                if (selected.contains(next)) continue;
                
                int count = 0;
                
                for (int i=0; i<next.length(); i++) {
                    
                    if (current.charAt(i)!=next.charAt(i)) count++;
                    
                }
                
                if (count==1) {
                    selected.add(next);
                    queue.add(new Word(next, change+1));
                }
                
            }
            
        }
        
        return answer;
    }
}