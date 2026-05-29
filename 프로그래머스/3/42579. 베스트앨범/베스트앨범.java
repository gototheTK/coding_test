import java.util.*;
import java.util.stream.Collectors;class Song implements Comparable<Song> {

    int index;

    String genre;

    int plays;

    public Song(int index, String genre, int plays) {
        this.index = index;
        this.genre = genre;
        this.plays = plays;
    }

    public int getIndex() {return this.index;}

    public String getGenre() {return this.genre;}

    public int getPlays() {return this.plays;}

    @Override
    public int compareTo(Song other) {

        if (this.plays == other.plays) {
            return Integer.compare(this.index, other.index);
        }

        return Integer.compare(other.plays, this.plays);
    }
}

class Solution {

    public int[] solution(String[] genres, int[] plays) {

        int[] answer = {};

        Map<String, List<Song>> songsByGenres = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            songsByGenres.computeIfAbsent(genres[i], key -> new ArrayList<>()).add(new Song(i, genres[i], plays[i]));
        }

        songsByGenres.values().forEach(Collections::sort);

        List<String> sortedGenres = songsByGenres.keySet().stream()
                .sorted((g1, g2) -> {
                    int sum1 = songsByGenres.get(g1).stream().mapToInt(Song::getPlays).sum();
                    int sum2 = songsByGenres.get(g2).stream().mapToInt(Song::getPlays).sum();
                    return Integer.compare(sum2, sum1);
                })
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> list = songsByGenres.get(genre);
            result.add(list.get(0).index);
            if (list.size() > 1) result.add(list.get(1).index);
        }

        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;

    }

}