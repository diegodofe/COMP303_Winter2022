import java.util.*;

/**
 * Represents an Audio library, with individual Song titles, Podcasts and
 * playlists.
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */

public class Library {

    // Static reference of Singleton Library object
    private static Library library;

    private String libraryName;
    private String libraryDescription;

    // Collection of unique Songs in the Singleton Library
    private final Set<Song> mySongs = new HashSet<>();

    // Collection of unique Podcasts in the Singleton Library
    private final Set<Podcast> myPodcasts = new HashSet<>();

    // Collection of unique Episodes in the Singleton Library
    private final Set<Episode> myEpisodes = new HashSet<>();

    // Collection of unique Playlists in the Singleton Library
    private final Set<PlayList> myPlayLists = new HashSet<>();

    /**
     * Private constructor that is only called from getInstance() method.
     */
    private Library() {
        this.libraryName = "Unnamed Library"; // Default
        this.libraryDescription = "No description."; // Default
    }

    /**
     * Returns the instance of the Singleton Library. If instance DNE, creates the
     * Singleton Library.
     * 
     * @return Singleton Library object
     */
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
     * Sets the name of the Library.
     *
     * @param libraryName the library name
     * 
     * @pre libraryName != null;
     * @throws IllegalArgumentException
     */
    public void setLibraryName(String libraryName) {
        assert libraryName != null;
        this.libraryName = libraryName;
    }

    /**
     * Sets the description of the Library.
     *
     * @param libraryDescription the library description
     * 
     * @pre libraryDescription != null;
     * @throws IllegalArgumentException
     */
    public void setLibraryDescription(String libraryDescription) {

        assert libraryDescription != null;
        this.libraryDescription = libraryDescription;
    }

    /**
     * Adds a Song to the library. Duplicate Songs aren't added twice.
     *
     * @param pSong the Song to add
     * 
     * @pre pSong != null;
     * @throws IllegalArgumentException
     */
    public void addSong(Song pSong) {
        assert pSong != null;

        if (!mySongs.contains(pSong)) {
            mySongs.add(pSong);
        }
    }

    /**
     * Adds a Episode to the library. Duplicate Episodes aren't added twice.
     *
     * @param pEpisode the Episode to add
     * 
     * @pre pEpisode != null;
     * @throws IllegalArgumentException
     */
    public void addEpisode(Episode pEpisode) {
        assert pEpisode != null;

        if (!myEpisodes.contains(pEpisode)) {
            myEpisodes.add(pEpisode);
        }
    }

    /**
     * Adds a PlayList to the library. All Songs and Episodes from the list are also
     * added as
     * individual Songs and Episodes to the library.
     *
     * @param pList the PlayList to add
     * 
     * @pre pList!=null;
     * @throws IllegalArgumentException
     */
    public void addPlayList(PlayList pList) {

        assert pList != null;

        if (!myPlayLists.contains(pList)) {

            myPlayLists.add(pList);

            // Add all individual Songs and Episodes
            for (Playable currentPlayable : pList.getaList()) {

                if (currentPlayable.getClass() == Song.class) {
                    addSong((Song) currentPlayable);
                } else if (currentPlayable.getClass() == Episode.class) {
                    addEpisode((Episode) currentPlayable);
                }
            }
        }

    }

    /**
     * Adds a Podcast to the library. All Episodes from the list are also added as
     * individual episodes to the library.
     *
     * @param pPodcast the Podcast to add
     * 
     * @pre pPodcast!=null;
     * @throws IllegalArgumentException
     */
    public void addPodcast(Podcast pPodcast) {
        assert pPodcast != null;

        if (!myPodcasts.contains(pPodcast)) {
            myPodcasts.add(pPodcast);

            for (int i = 0; i < pPodcast.getNumEpisodes(); i++) {
                addEpisode(pPodcast.getEpisode(i));
            }
        }
    }

    /**
     * Plays all song and episodes in the library
     */
    public void playEntireLibrary() {

        if (!mySongs.isEmpty()) {
            System.out.println("Playing All Songs:");
            for (Song s : mySongs) {
                s.play();
            }
        }

        if (!myEpisodes.isEmpty()) {
            System.out.println("\nPlaying All Episodes:");
            for (Episode e : myEpisodes) {
                e.play();
            }
        }

    }
}
