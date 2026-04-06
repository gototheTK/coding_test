import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        // 목표 숫자가 N과 같다면 1번 만에 만들 수 있으므로 즉시 1 반환
        if (N == number) {
            return 1;
        }
        
        //  DP 상태를 저장할 Set의 리스트 (배열 대신 리스트를 사용합니다)
        List<Set<Integer>> dp = new ArrayList<>();
        
        //  인덱스를 1부터 8까지 직관적으로 쓰기 위해 9칸을 초기화 둡니다.
        //  문제 조건: "최솟값이 8보다 크면 -1을 return"
        for (int i=0; i<=8; i++) {
            dp.add(new HashSet<>());
        }
        
        //  기저 조건 : N을 1번 써서 만들 수 있는 수는 N 자기 자신뿐입니다.
        dp.get(1).add(N);
        
        //  N을 2번 쓰는 경우부터는 8번 쓰는 경우까지 탐색을 시작합니다.
        for (int i=2; i<=8; i++) {
            Set<Integer> currentSet = dp.get(i);
            
            //  1. N을 i번 연달아 이어 붙인 숫자를 먼저 넣습니다. (예: 55, 555)
            StringBuilder sb =new StringBuilder();
            for (int j=0; j<i; j++) {
                sb.append(N);
            }
            currentSet.add(Integer.parseInt(sb.toString()));
            
            //  2. 사칙연산 조합하기
            //  i가 4라면 -> (j=1, k=3), (j=2, k=2), (j=3, k=1)의 조합을 만듭니다.
            for (int j=1; j<i; j++) {
                int k = i-j;
                
                //  j번 쓴 집합의 모든 숫자와 k번 쓴 집합의 모든 숫자를 꺼내서 사칙 연산!
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(k)) {
                        currentSet.add(num1 + num2);
                        currentSet.add(num1 - num2);
                        currentSet.add(num1 * num2);
                        //  나눗셈은 0으로 나누는 경우를 반드시 방어해야 합니다.
                        if (num2 != 0) {
                            currentSet.add(num1/num2);
                        }
                    }
                }
                
            }
            
            //  3. 방금 만든 currentSet(i번 써서 만든 수의 집합)에 목표 숫작 있다면?
            //  최소 횟수부터 차례대로 올라왔으므로, i가 무조건 최솟값입니다.
            if (currentSet.contains(number)) {
                return i;
            }
        }
        
        return answer;
    }
}