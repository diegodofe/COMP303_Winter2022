import java.util.*;

/**
 * Represents an Audio library, with individual Song titles, Podcasts and
 * playlists.
 */
public class Library {

    private static Library library;
    private String libraryName;
    private String libraryDescription;

    public final Set<Song> mySongs = new HashSet<>();
    public final Set<Podcast> myPodcasts = new HashSet<>();

    private Library() {
        this.libraryName = "Unnamed Library";
        this.libraryDescription = "No description.";
    }

    public static Library getInstance() {
        if (null == library) {
            library = new Library();
        }

        return library;
    }

    public String getLibraryName() {
        return this.libraryName;
    }

    public String getLibraryDescription() {
        return this.libraryDescription;
    }

    /**
     * Sets the name of the library.
     *
     * @param libraryName the library name
     * 
     * @pre libraryName != null;
     */
    public void setLibraryName(String libraryName) {
        assert libraryName != null;
        this.libraryName = libraryName;
    }

    /**
     * Sets the description of the library.
     *
     * @param libraryDescription the library description
     * 
     * @pre libraryDescription != null;
     */
    public void setLibraryDescription(String libraryDescription) {

        assert libraryDescription != null;
        this.libraryDescription = libraryDescription;
    }

    /**
     * Adds your design of fields for Library
     *
     * 
     * 
     * /**
     * Adds a Song to the library. Duplicate Songs aren't added twice.
     *
     * @param pSong the Song to add
     */
    public void addSong(Song pSong) {
        assert pSong != null;

        if (!mySongs.contains(pSong)){
            mySongs.add(pSong);
        }
    }

    /**
     * Adds a PlayList to the library. All Songs from the list are also added as
     * individual Songs to the library.
     *
     * @param pList the PlayList to add
     * 
     * @pre pList!=null;
     */
    public void addPlayList(PlayList pList) {
        // Please add you implementation here
    }

    /**
     * Adds a Podcast to the library. All Episodes from the list are also added as
     * individual episodes to the library.
     *
     * @param pPodcast the Podcast to add
     * 
     * @pre pPodcast!=null;
     */
    public void addPodcast(Podcast pPodcast) {
        // Please add you implementation here

        assert pPodcast != null;

        if (!myPodcasts.contains(pPodcast)){
            myPodcasts.add(pPodcast);
        }
    }

}
