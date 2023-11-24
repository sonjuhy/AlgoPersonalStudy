package programmers;

import java.util.*;
import java.util.stream.IntStream;

public class PG_42579 {
    public static void main(String[] args) {
        String[] genres = {"classic","pop","classic","pop","classic","classic"};
        int[] plays = {400,600,150,2500,500,500};

        int[] resultList = solution(genres, plays);
        for(int result : resultList)System.out.println(result);
    }
    public static int[] solution(String[] genres, int[] plays){
        int[] answer;
        List<Integer> listAnswer = new ArrayList<>();

        HashMap<String, PriorityQueue<Integer>> playTimeHashMap = new HashMap<>();
        HashMap<String, Integer> genreHashMap = new HashMap<>();
        List<Song> songList = new ArrayList<>();
        int len = genres.length;

        for(int i=0;i<len;i++){
            String genre = genres[i];
            int playTime = plays[i];
            songList.add(new Song(genre, playTime));

            if(playTimeHashMap.containsKey(genre)){
                playTimeHashMap.get(genre).add(playTime);
            }
            else {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.add(playTime);
                playTimeHashMap.put(genre,pq);
            }
            if(genreHashMap.containsKey(genre)) genreHashMap.replace(genre, genreHashMap.get(genre)+1);
            else genreHashMap.put(genre, 1);
        }

        PriorityQueue<Genre> genresPQ = new PriorityQueue<>(Collections.reverseOrder());
        for(String key : genreHashMap.keySet()){
            List<Integer> playCountList = new ArrayList<>(playTimeHashMap.get(key));
            int tmp = 0;
            for(int i : playCountList){
                tmp += i;
            }
            Genre genre = new Genre(key, tmp);
            genresPQ.add(genre);
        }

        while(!genresPQ.isEmpty()){
            Genre genre = genresPQ.poll();
            PriorityQueue<Integer> playTimePQ = playTimeHashMap.get(genre.name);

            for(int i=0;i<2;i++){
                int place = songList.indexOf(new Song(genre.name, playTimePQ.poll()));
                songList.get(place).used = true;
                listAnswer.add(place);
                if(playTimePQ.size() == 0){
                    break;
                }
            }

        }
        answer = new int[listAnswer.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = listAnswer.get(i);
        }
        return answer;
    }
    static class Genre implements Comparable<Genre>{
        String name;
        int count;

        public Genre(String name, int count){
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Genre o) {
            if(this.count < o.count) return -1;
            else if(this.count > o.count) return 1;
            return 0;
        }
    }
    static class Song {
        String genre;
        int playTime;
        boolean used;

        public Song(String genre, int playTime){
            this.genre = genre;
            this.playTime = playTime;
            this.used = false;
        }

        @Override
        public boolean equals(Object obj) {
            Song song = (Song) obj;
            return (this.genre.equals(song.genre) && this.playTime == song.playTime && this.used == song.used);
        }
    }
}
