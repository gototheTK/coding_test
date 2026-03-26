import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, List<Integer>> genresMap = new HashMap<>();
        Map<String, Integer> playsSumMap = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            
            String genre = genres[i];
            int play = plays[i];
            
            List<Integer> list = genresMap.computeIfAbsent(genre, k -> new ArrayList<>());
            list.add(i);
            
            playsSumMap.put(genre, playsSumMap.getOrDefault(genre, 0) + play);
            
        }
        
        List<String> sortedGenres = playsSumMap.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue() - e1.getValue())
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        List<Integer> bestAlbums = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            
            List<Integer> albums = genresMap.get(genre);
            albums.sort((a, b) -> plays[b]-plays[a]);
            
            bestAlbums.add(albums.get(0));
            
            if (albums.size()>1) {
                bestAlbums.add(albums.get(1));
            }
            
        }
        
        answer = bestAlbums.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}