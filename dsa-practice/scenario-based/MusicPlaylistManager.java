
import java.util.*;

class SongAlreadyExistsException extends Exception {
    public SongAlreadyExistsException(String message) {
        super(message);
    }
}


class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Song)) return false;

        Song s = (Song) obj;
        return title.equalsIgnoreCase(s.title)
                && artist.equalsIgnoreCase(s.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), artist.toLowerCase());
    }

    @Override
    public String toString() {
        return title + " - " + artist;
    }
}


class PlaylistManager {

    private LinkedList<Song> playlist = new LinkedList<>();
    private Stack<Song> history = new Stack<>();
    private Set<Song> songSet = new HashSet<>();

    // Add song to playlist
    public void addSong(Song song) throws SongAlreadyExistsException {

        if (songSet.contains(song)) {
            throw new SongAlreadyExistsException(
                    "Song already exists in playlist!");
        }

        playlist.add(song);
        songSet.add(song);

        System.out.println("Added: " + song);
    }

    // Play next song
    public void playSong() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty!");
            return;
        }

        Song current = playlist.removeFirst();
        history.push(current);

        System.out.println("Now playing: " + current);
    }

    // Show recently played
    public void showHistory() {
        System.out.println("Recently played:");

        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
    }

    // Show playlist
    public void showPlaylist() {
        System.out.println("Current playlist:");
        playlist.forEach(System.out::println);
    }
}


public class MusicPlaylistManager {
    public static void main(String[] args) {

        PlaylistManager manager = new PlaylistManager();

        try {
            manager.addSong(new Song("Shape of You", "Ed Sheeran"));
            manager.addSong(new Song("Believer", "Imagine Dragons"));
            manager.addSong(new Song("Shape of You", "Ed Sheeran")); // duplicate
        }
        catch (SongAlreadyExistsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        manager.showPlaylist();

        manager.playSong();
        manager.playSong();

        manager.showHistory();
    }
}
