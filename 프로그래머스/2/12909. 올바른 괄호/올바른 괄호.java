import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] chs = s.toCharArray();

        Queue<Character> queue = new ArrayDeque<>();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : chs) {
            queue.add(c);
        }

        while (!queue.isEmpty()) {

            char c = queue.poll();

            if (deque.isEmpty()) {
                deque.add(c);
            }else {

                char peek = deque.peek();

                if (c == ')' && peek == '(') {
                    deque.pop();
                }else if (c == '(' && peek == '(') {
                    deque.add(c);
                }else {
                    return false;
                }
            }

        }

        answer = deque.isEmpty();

        return answer;
    }
}