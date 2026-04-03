import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        
        /**
        보석들의 종류와 종류수를 구해야한다.
        
        종류수 만큼의 슬라이딩 윈도우를 이용하여서, 처음부터 끝까지 확인한다.
        
        그 처리 중에서 보석이 다 구해지면, 시작점과 끝점 그리고 길이를 비교하면서 갱신한다.
        
        슬라이딩 윈도우를 다 마치면 해당 시작점과 끝점을 반환한다.
        
        **/
        
        int types = Arrays.stream(gems).collect(Collectors.toSet()).size();
        
        Map<String, Integer> typesMap = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int minLen = gems.length+1;
        
        while (true) {
            
            int count = typesMap.size();
            
            if (count == types) {
                
                if (minLen > right-left) {
                    minLen = right-left;
                    answer = new int[]{left+1, right};
                }
                
                int gemsCount = typesMap.get(gems[left])-1;
                
                if (gemsCount==0) {
                    typesMap.remove(gems[left]);
                }else {
                    typesMap.put(gems[left], gemsCount);
                }
                
                left++;
                
            }else if (right == gems.length) {
                break;
            }else {
                typesMap.put(gems[right], typesMap.getOrDefault(gems[right], 0)+1);
                right++;
            }
            
        }
        
        return answer;
    }
}