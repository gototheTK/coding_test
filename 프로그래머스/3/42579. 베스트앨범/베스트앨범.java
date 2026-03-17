import java.util.*;
import java.util.stream.*;

class Solution {
    
    static class Album {
        int index;
        int plays;
        
        public Album(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, List<Album>> albumsMap = new HashMap<>();
        Map<String, Integer> playsSums = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            
           albumsMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Album(i, plays[i]));
            
            playsSums.put(genres[i], playsSums.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> sortedGenres = albumsMap.keySet().stream().sorted((a, b)->playsSums.get(b)-playsSums.get(a)).collect(Collectors.toList());
        List<Integer> bestAlbums = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            
            List<Album> list = albumsMap.get(genre);
            list.sort((a, b) -> a.plays==b.plays ? a.plays : b.plays-a.plays);
            
            bestAlbums.add(list.get(0).index);
            
            if (list.size()>1) bestAlbums.add(list.get(1).index);
            
        }
        
        answer = bestAlbums.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}