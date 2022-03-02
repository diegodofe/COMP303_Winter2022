import java.util.*;

/**
 * Represents a single Song, with at least a title, and an artist name.
 */
public class Song implements Playable {

    private static final List<Song> allSongs = new ArrayList<>();
    private final String aTitle;
    private final String aArtist;

    public static Song getSong(String pTitle, String pArtist){

        Song requestedSong = new Song(pTitle, pArtist);

        if (allSongs.isEmpty()){
            allSongs.add(requestedSong);
            return requestedSong;
        }

        for (int i = 0; i<allSongs.size();i++){
            Song tempSong = allSongs.get(i);
            if (tempSong.equals(requestedSong)){
                return tempSong;
            }
        }

        allSongs.add(requestedSong);
        
        return requestedSong;
    }

    /**
     * Creates a Song.
     * Add your constructor here
     */
    private Song(String pTitle, String pArtist) {
        aTitle = pTitle.toLowerCase();
        aArtist = pArtist.toLowerCase();
    }

    public void play() {
        // Just a stub.
        // We don't expect you to implement an actual music player!
        System.out.println("Now playing " + aTitle);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aArtist == null) ? 0 : aArtist.hashCode());
        result = prime * result + ((aTitle == null) ? 0 : aTitle.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Song other = (Song) obj;
        if (aArtist == null) {
            if (other.aArtist != null)
                return false;
        } else if (!aArtist.equals(other.aArtist))
            return false;
        if (aTitle == null) {
            if (other.aTitle != null)
                return false;
        } else if (!aTitle.equals(other.aTitle))
            return false;
        return true;
    }

    public String getTitle() {
        return aTitle;
    }

    public String getArtist() {
        return aArtist;
    }
}