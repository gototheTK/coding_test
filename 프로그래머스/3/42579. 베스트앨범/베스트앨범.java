import java.util.*;
import java.util.stream.Collectors;

    class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, List<Integer>> genrePlays = new HashMap<>();
        Map<String, List<Integer>> genreIndexes = new HashMap<>();

        for (int i=0; i<genres.length; i++) {

            List<Integer> genreList = genrePlays.computeIfAbsent(genres[i], key-> new ArrayList<>());
            List<Integer> indexList = genreIndexes.computeIfAbsent(genres[i], key -> new ArrayList<>());

            genreList.add(plays[i]);
            indexList.add(i);
        }

        Map<String, Integer> playsSums = genrePlays.entrySet().stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(
                        entry.getKey(),
                        entry.getValue().stream().mapToInt(Integer::intValue).sum()
                ))
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        genreIndexes.forEach((key, list) -> list.sort(
                (i1, i2) -> plays[i2] - plays[i1]
        ));


        List<Integer> result = new ArrayList<>();

        for (String genre : playsSums.keySet()) {
            
            List<Integer> list = genreIndexes.get(genre);
            
            result.add(list.get(0));
            
            if (list.size() > 1) result.add(list.get(1));
            
        }
        
        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}