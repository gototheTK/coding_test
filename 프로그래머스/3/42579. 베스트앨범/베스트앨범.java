import java.util.*;
import java.util.stream.*;


class Solution {

    public int[] solution(String[] genres, int[] plays) {

        int[] answer = {};

        Map<String, List<Integer>> genresMap = new HashMap<>();
        Map<String, Integer> playsMap = new LinkedHashMap<>();

        for (int i=0; i<genres.length; i++) {
            genresMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
            playsMap.put(genres[i], playsMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> bestGenres = playsMap.entrySet().stream()
                .sorted((a, b) -> b.getValue()-a.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        

        List<Integer> bestAlbums = new ArrayList<>();

        for (String genre : bestGenres) {

            List<Integer> albums = genresMap.get(genre).stream()
                    .sorted((a, b) -> plays[a]==plays[b] ? plays[a] : plays[b]-plays[a])
                    .collect(Collectors.toList());

            bestAlbums.add(albums.get(0));

            if (albums.size()>1) bestAlbums.add(albums.get(1));

        }

        answer = bestAlbums.stream().mapToInt(Integer::intValue).toArray();

        return  answer;

    }

}