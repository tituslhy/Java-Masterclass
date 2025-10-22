package PlaylistChallenge;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
//    private ArrayList<Song> songs;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
//        this.songs = new ArrayList<>();
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration){
        return songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = songs.findSong(title);
        if (song == null) {
            System.out.println("The song " + title + " is not in this album");
            return false;
        }
        playlist.add(song);
        return true;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        Song song = songs.findSong(trackNumber);
        if (song == null) {
            System.out.println("This album does not have a track " + trackNumber);
            return false;
        }
        playlist.add(song);
        return true;
    }

    public static class SongList{
        private ArrayList<Song> songs = new ArrayList<Song>();

        private SongList(){}

        private boolean add(Song song){
            if (findSong(song.getTitle()) != null) {
                return false; // song already exists
            }
            songs.add(song);
            return true;
        }

        private Song findSong(String title){
            for (Song song : songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if (index >= 0 && index < songs.size()) {
                return songs.get(index);
            }
            return null;
        }
    }
}
