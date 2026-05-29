import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;class Solution {

    static class Song implements Comparable<Song> {

        int index;

        String genre;

        int plays;

        public int getIndex() {return this.index;}

        public String getGenre() {return this.genre;}

        public int getPlays() {return this.plays;}

        public Song(int index, String genre, int plays) {
            this.index = index;
            this.genre = genre;
            this.plays = plays;
        }

        @Override
        public int compareTo(Song o){

            if(this.plays == o.plays){
                return Integer.compare(this.index, o.index);
            }

            return Integer.compare(o.plays, this.plays);
        }

    }

    public int[] solution(String[] genres, int[] plays) {

        int[] answer = {};

        Map<String, List<Song>> songsByGenre = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            songsByGenre.computeIfAbsent(genres[i], key -> new ArrayList<>()).add(new Song(i, genres[i], plays[i]));
        }

        songsByGenre.values().forEach(Collections::sort);

        List<String> sortedGenres = songsByGenre.keySet().stream()
                .sorted((s1, s2) -> {
                    int sum1 = songsByGenre.get(s1).stream().mapToInt(Song::getPlays).sum();
                    int sum2 = songsByGenre.get(s2).stream().mapToInt(Song::getPlays).sum();

                    return Integer.compare(sum2, sum1);
                })
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> sortedSongs = songsByGenre.get(genre);
            result.add(sortedSongs.remove(0).index);
            if (!sortedSongs.isEmpty()) result.add(sortedSongs.remove(0).index);
        }
        
        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;

    }

}


