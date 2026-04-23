import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        if (N == number) return 1;
        
        /**
        1. 이전의 연산결과에 사칙연산을 한 결과를 새로만들어 저장한다.
        2. 이렇게 최대 8번까지하고, 없다면 -1을 리턴한다.
        3. 사칙연산 중에 0으로 나누지 않도록 주의한다.
        
        자료구조는 List와 Set을 사용한다.
        **/
        
        List<Set<Integer>> list = new ArrayList<>();
        
        for (int i=0; i<=8; i++) {
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        for (int i=2; i<=8; i++) {
            
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            
            list.get(i).add(num);
            
            for (int j=1; j<=i/2; j++) {
                
                int k = i-j;
                
                for (int num1 : list.get(j)) {
                
                    for (int num2 : list.get(k)) {

                        list.get(i).add(num1 + num2);
                        list.get(i).add(num1 * num2);
                        
                        list.get(i).add(num1 - num2);
                        list.get(i).add(num2 - num1);
                        
                        if (num1!=0) list.get(i).add(num2/num1);
                        if (num2!=0) list.get(i).add(num1/num2);

                    }

                }
                
            }
            
            if (list.get(i).contains(number)) return i;
            
        }
        
        
        return answer;
    }
}