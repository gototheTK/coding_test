import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        if (N == number) return 1;
            
        /**
        배열을 만들어서, 타뷸레이션 방법으로 구한다.
        즉, 이전에 만들었던 조합으로, 또 조합을 만드는거다.
        가령 N 과 NN, N+N, N-N, N*N, N/N
        이를 8번까지 하는데, 결과 값은 Set으로 저장한다.
        Set에 number가 나오면 그 횟수를 리턴한다.
        **/
        
        List<Set<Integer>> list = new ArrayList<>();
        
        for (int i=0; i<=8; i++) {
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        for (int i=2; i<=8; i++) {
            
            list.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for (int j=1; j<i; j++) {
                
                int k = i-j;
                
                for (int num1 : list.get(j)) {
                    
                    for (int num2 : list.get(k)) {
                        
                        list.get(i).add(num1 + num2);
                        list.get(i).add(num1 - num2);
                        list.get(i).add(num1 * num2);
                        
                        if (num2>0) list.get(i).add(num1 / num2);
                        
                    }
                    
                }
                
            }
            
            if (list.get(i).contains(number)) return i;
            
        }
        
        return answer;
    }
}