import java.util.*;

class Solution {

    static class Word {

        String word;
        int change;
        
        public Word(String word, int change) {
            this.word = word;
            this.change = change;
        }

    }

    public int solution(String begin, String target, String[] words) {

        int answer = 0;
        
        int min = 0;

        Queue<Word> queue = new ArrayDeque<>();
        queue.add(new Word(begin, 0));

        Set<String> selected = new HashSet<>();
        selected.add(begin);

        while (!queue.isEmpty()) {

            Word word = queue.poll();

            
            if (word.word.equals(target)) {
                min = word.change;
            }

            for (String s : words) {
                
                if (selected.contains(s)) continue;

                int count = 0;

                char[] ch1 = word.word.toCharArray();
                char[] ch2 = s.toCharArray();

                for (int j = 0; j < ch1.length; j++) {
                    if (ch1[j] != ch2[j]) count++;
                }

                if (count == 1) {
                    queue.add(new Word(s, word.change+1));
                    selected.add(s);
                }

            }

        }

        answer = min;

        return answer;

    }

}