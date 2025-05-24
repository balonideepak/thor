package work.rippling;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Design a Music Player like Spotify with below methods
 * <p>
 * <p>
 * https://leetcode.com/discuss/post/6314198/rippling-l6-interview-experience-reject-7csud/
 * <p>
 * int addSong(string songTitle); // add a song to your music player with incremental song ids starting from 1
 * void playSong(int songId, int userId); // user plays a song that is present in the music player
 * void printMostPlayedSongs(); // print song titles in decreasing order of number of unique users' plays
 */

public class MusicPlayerUserLevel {

    private static final Map<Integer, Song> songMap = new ConcurrentHashMap<>();
    private static final int K_MOST_POPULAR_SONGS = 2;
    private static final PriorityQueue<Song> pq = new PriorityQueue<>(K_MOST_POPULAR_SONGS);
    private static final Map<Integer , PriorityQueue<Song>> userSongsMapping = new HashMap<>();
    private static final AtomicInteger songIdGenerator = new AtomicInteger(1);

    public static void main(String[] args) {
        int userId = 1;
        int songId = addSong("a");
        playSong(songId,userId);
        playSong(songId,userId);
        playSong(songId,userId);
        playSong(songId,userId);
        playSong(songId,userId);

        songId = addSong("b");
        userId = 2;
        playSong(songId,userId);

        songId = addSong("c");
        userId = 3;
        playSong(songId,userId);

        songId = addSong("d");
        playSong(songId,userId);
        playSong(songId,userId);

        songId = addSong("e");
        playSong(songId,userId);

        List<String> mostPlayedSongs = fetchMostPlayedSongs();
        System.out.println("most played songs");
        System.out.println(mostPlayedSongs);

    }

    public static int addSong(String songTitle) {
        int songId = songIdGenerator.getAndIncrement();
        if (!songMap.containsKey(songId)) {
            songMap.put(songId, new Song(songTitle , songId));
        }
        System.out.println("added song: " + songTitle);
        return songId;
    }

    public static void playSong(int songId , int userId) {
        Song song = songMap.get(songId);
        if (song == null) {
            return;
        }

        song.setNumberOfTimesPlayed(song.getNumberOfTimesPlayed() + 1);

        System.out.println("playing " + song);
        processSongPopularity(song , userId);
    }

    private static void processSongPopularity(Song song , int userId) {
        PriorityQueue<Song> pq = userSongsMapping.getOrDefault(userId , new PriorityQueue<>(K_MOST_POPULAR_SONGS));
        pq.remove(song); // ensures old version is removed
        pq.offer(song);
        if (pq.size() > K_MOST_POPULAR_SONGS) {
            pq.poll();
        }
    }

    public static List<String> fetchMostPlayedSongs() {

        List<Song> mostPlayedSongs = new ArrayList<>();
        userSongsMapping.forEach((key, value) -> mostPlayedSongs.addAll(value));
        return mostPlayedSongs.stream()
                .sorted(Comparator.comparingInt(Song::getNumberOfTimesPlayed).reversed())
                .map(Song::getSongTitle)
                .collect(Collectors.toList());
    }


    private static class Song implements Comparable<Song> {

        String songTitle;
        int songId;
        int numberOfTimesPlayed;

        public Song(String songTitle , int songId) {
            this.songTitle = songTitle;
            this.songId = songId;
        }

        public String getSongTitle() {
            return songTitle;
        }

        public void setSongTitle(String songTitle) {
            this.songTitle = songTitle;
        }

        public int getSongId() {
            return songId;
        }

        public void setSongId(int songId) {
            this.songId = songId;
        }

        public int getNumberOfTimesPlayed() {
            return numberOfTimesPlayed;
        }

        public void setNumberOfTimesPlayed(int numberOfTimesPlayed) {
            this.numberOfTimesPlayed = numberOfTimesPlayed;
        }

        @Override
        public int compareTo(Song o) {
            return this.numberOfTimesPlayed - o.getNumberOfTimesPlayed() ;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "songTitle='" + songTitle + '\'' +
                    '}';
        }
    }


}
