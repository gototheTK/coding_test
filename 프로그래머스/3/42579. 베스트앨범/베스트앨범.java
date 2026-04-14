import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        /**
        장르별 곡들을 분류한다.
        가장 많이 재생된 장르의 순위를 정렬하고,
        분류한 곡들을 재생순으로 순위를 매긴다.
        **/
        
        Map<String, List<Integer>> bestGenresMap = new HashMap<>();
        Map<String, Integer> bestPlaysMap = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            
            bestGenresMap.computeIfAbsent(genres[i], k ->new ArrayList<>());
            bestGenresMap.get(genres[i]).add(i);
            
            int sum = bestPlaysMap.getOrDefault(genres[i], 0) + plays[i];
            bestPlaysMap.put(genres[i], sum);
        }
        
        List<String> bestGenres = bestGenresMap.keySet().stream()
            .sorted((o1, o2) -> bestPlaysMap.get(o2)-bestPlaysMap.get(o1))
            .collect(Collectors.toList());
        
        List<Integer> result = new ArrayList<>();
        
        for (String genre : bestGenres) {
            
            List<Integer> list = bestGenresMap.get(genre).stream()
                .sorted((o1, o2)-> {
                    
                    if (plays[o1]==plays[o2]) return o1-o2;
                    
                    return plays[o2]-plays[o1];
                    
                })
                .collect(Collectors.toList());
            
            result.add(list.get(0));
            
            if (list.size()>1)
                result.add(list.get(1));
            
        }
        
        answer = result.stream().mapToInt(Integer::valueOf).toArray();
        
        return answer;
    }
}