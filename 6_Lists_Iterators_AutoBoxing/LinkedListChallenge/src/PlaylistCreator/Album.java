package PlaylistCreator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration){
        Song song = new Song(title, duration);
        if (findSong(title) != null) {
            return false; // song already exists
        }
        songs.add(new Song(title, duration));
        return true;
    }

    public boolean addToPlayList(int track_number, LinkedList<Song> playlist){
        if (track_number < 1 || track_number > songs.size()) return false;
        Song song = songs.get(track_number - 1);
        playlist.add(song);
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        if (findSong(title) == null){
            return false;
        }
        Song song = findSong(title);
        playlist.add(song);
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
}
