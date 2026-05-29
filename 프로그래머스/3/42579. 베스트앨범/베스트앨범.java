import java.util.*;
import java.util.stream.Collectors;

class Solution {

    static class Song implements Comparable<Song> {

        int index;

        String genre;

        int plays;

        public int getIndex() { return this.index; }

        public String getGenre() { return this.genre; }

        public int plays() {return this.plays;}

        public Song(int index, String genre, int plays) {
            this.index = index;
            this.genre = genre;
            this.plays = plays;
        }

        @Override
        public int compareTo(Song other) {

            if (this.plays == other.plays) {
                return Integer.compare(this.index, other.index);
            }

            return Integer.compare(other.plays, this.plays);

        }

    }

    public int[] solution(String[] genres, int[] plays) {

        int[] answer = {};

        Map<String, List<Song>> songsByGenre = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            songsByGenre.computeIfAbsent(genres[i], genre -> new ArrayList<>()).add(new Song(i, genres[i], plays[i]));
        }

        songsByGenre.values().forEach(Collections::sort);

        List<String> sortedGenres = songsByGenre.keySet().stream()
                .sorted((genre1, genre2) -> {
                    int sum1 = songsByGenre.get(genre1).stream().mapToInt(Song::plays).sum();
                    int sum2 = songsByGenre.get(genre2).stream().mapToInt(Song::plays).sum();

                    return Integer.compare(sum2, sum1);
                })
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres) {

            List<Song> songs = songsByGenre.get(genre);

            result.add(songs.remove(0).index);
            if (!songs.isEmpty()) {
                result.add(songs.remove(0).index);
            }

        }
        
        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;

    }

}