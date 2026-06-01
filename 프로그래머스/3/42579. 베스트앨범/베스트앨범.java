import java.util.*;

class Solution {

    class Album implements Comparable<Album> {

        String genre;

        int plays;

        int index;

        public Album (String genre, int plays, int index) {
            this.genre = genre;
            this.plays = plays;
            this.index = index;
        }


        @Override
        public int compareTo(Album o) {

            if (o.plays == this.plays) return 0;

            return Integer.compare(o.plays, this.plays);

        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, List<Album>> albumsByGenre = new HashMap<>();

        for (int index=0; index<genres.length; index++) {
            albumsByGenre.computeIfAbsent(genres[index], key -> new ArrayList<>()).add(new Album(genres[index], plays[index], index));
        }

        albumsByGenre.values().forEach(Collections::sort);

        List<String> sortedGenres = albumsByGenre.entrySet().stream()
                .sorted((e1, e2) -> {

                    int sum1 = e1.getValue().stream().mapToInt(album -> album.plays).sum();
                    int sum2 = e2.getValue().stream().mapToInt(album -> album.plays).sum();

                    return Integer.compare(sum2, sum1);
                }).map(Map.Entry::getKey)
                .toList();

        List<Integer> result = new ArrayList<>();

        for (String genre: sortedGenres) {

            List<Album> albums = albumsByGenre.get(genre);

            result.add(albums.remove(0).index);

            if (!albums.isEmpty()) result.add(albums.remove(0).index);

        }

        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

}