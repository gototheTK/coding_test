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
        selected.add(begin);
        
        while (!queue.isEmpty()) {
            
            Word current = queue.poll();
            
            String word = current.word;
            int change = current.change;
            
            if (word.equals(target)) return change;
            
            for (String next : words) {
                
                if (selected.contains(next)) continue;
                
                int count = 0;
                
                for (int i=0; i<next.length(); i++) {
                    if (current.word.charAt(i)!=next.charAt(i)) count++;
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