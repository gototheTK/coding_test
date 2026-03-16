import java.util.*;
import java.util.stream.Collectors;

class Solution {

    static class Album {

        int index;
        int play;

        public Album(int index, int play) {
            this.index = index;
            this.play = play;
        }

    }

    public int[] solution(String[] genres, int[] plays) {

        int[] answer = {};

        Map<String, List<Album>> bestAlbumsMap = new HashMap<>();

        for (int i=0; i<genres.length; i++) {

            List<Album> list = bestAlbumsMap.getOrDefault(genres[i], new ArrayList<>());
            list.add(new Album(i, plays[i]));
            bestAlbumsMap.put(genres[i], list);

        }

        for (String key : bestAlbumsMap.keySet()) {
            List<Album> list = bestAlbumsMap.get(key);
            list.sort((a, b)->b.play-a.play);
        }

        Map<String, List<Album>> sortedAlbums = bestAlbumsMap.entrySet().stream()
                .sorted((a, b) -> {

                    List<Album> albumsA = a.getValue();
                    List<Album> albumsB = b.getValue();

                    int sumA = 0, sumB = 0;

                    for (Album album : albumsA) {
                        sumA += album.play;
                    }

                    for (Album album : albumsB) {
                        sumB += album.play;
                    }
                    return sumB-sumA;
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2)->e1,
                        LinkedHashMap::new
                ));

        List<Integer> bestAlbums = new ArrayList<>();
        
        for (Map.Entry<String, List<Album>> entry : sortedAlbums.entrySet()) {
            
            List<Album> album = entry.getValue();
            bestAlbums.add(album.get(0).index);
            
            if (album.size()>1)
                bestAlbums.add(album.get(1).index);
            
        }
        
        answer = bestAlbums.stream().mapToInt(Integer::intValue).toArray();

        return answer;

    }

}