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

public class MusicPlayer {

    private static final Map<Integer, Song> songMap = new ConcurrentHashMap<>();
    private static final int K_MOST_POPULAR_SONGS = 2;
    private static final PriorityQueue<Song> pq = new PriorityQueue<>(K_MOST_POPULAR_SONGS);
    private static final AtomicInteger songIdGenerator = new AtomicInteger(1);

    public static void main(String[] args) {
        int songId = addSong("a");
        playSong(songId);
        playSong(songId);
        playSong(songId);
        playSong(songId);
        playSong(songId);

        songId = addSong("b");
        playSong(songId);

        songId = addSong("c");
        playSong(songId);

        songId = addSong("d");
        playSong(songId);
        playSong(songId);

        songId = addSong("e");
        playSong(songId);

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

    public static void playSong(int songId) {
        Song song = songMap.get(songId);
        if (song == null) {
            return;
        }

        song.setNumberOfTimesPlayed(song.getNumberOfTimesPlayed() + 1);

        System.out.println("playing " + song);
        processSongPopularity(song);
    }

    private static void processSongPopularity(Song song) {
        pq.remove(song); // ensures old version is removed
        pq.offer(song);
        if (pq.size() > K_MOST_POPULAR_SONGS) {
            pq.poll();
        }
    }

    public static List<String> fetchMostPlayedSongs() {
        return pq.stream()
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
