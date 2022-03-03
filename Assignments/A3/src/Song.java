import java.util.*;

/**
 * Represents a single Song, with at least a title, and an artist name.
 */
public class Song implements Playable {

    // Cache of current flyweight Songs.
    private static final List<Song> songsCache = new ArrayList<>();

    private final String aTitle;
    private final String aArtist;

    /**
     * Creates a song. Private constructor that is only called from getSong()
     * method.
     *
     * @param pTitle  title of the song
     * @param pArtist artist name of the song
     * 
     * @pre pTitle != null && pArtist!=null
     * @throws IllegalArgumentException
     */
    private Song(String pTitle, String pArtist) {

        assert (pTitle != null) && (pArtist != null);

        aTitle = pTitle.toLowerCase();
        aArtist = pArtist.toLowerCase();
    }

    public String getTitle() {
        return aTitle;
    }

    public String getArtist() {
        return aArtist;
    }

    /**
     * Returns a song based on the current cache of flyweight songs
     * 
     * @param pTitle  title of the episode
     * @param pArtist artist name of the song
     * @return Song object
     */
    public static Song getSong(String pTitle, String pArtist) {

        // Temp Song object to compare Song objects in the cache.
        Song requestedSong = new Song(pTitle, pArtist);

        if (songsCache.isEmpty()) {
            songsCache.add(requestedSong);
            return requestedSong;
        }

        // Check the Song cache to see if the song already exists.
        for (int i = 0; i < songsCache.size(); i++) {
            Song tempSong = songsCache.get(i);

            // If the Song already exists return it to the Client.
            if (tempSong.equals(requestedSong)) {
                return tempSong;
            }
        }

        // Song DNE, therefore add it to cache and return it.
        songsCache.add(requestedSong);

        return requestedSong;
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
}