import java.util.*;

/**
 * Represents a single episode, with at least a title, and an episode number.
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */

public class Episode implements Playable {

    // Cache of current flyweight Episodes.
    private static final List<Episode> episodeCache = new ArrayList<>();

    private final Podcast aPodcast;
    private final String aTitle;
    private final int aEpisodeNumber;

    /**
     * Creates an episode. Private constructor that is only called from getEpisode()
     * method.
     *
     * @param pPodcast       Podcast that this episode is a part of
     * 
     * @param pTitle         title of the episode
     * 
     * @param pEpisodeNumber the episode number that identifies the episode
     * 
     * @pre pPodcast != null && pTitle!=null
     * @throws IllegalArgumentException
     */
    private Episode(Podcast pPodcast, String pTitle, int pEpisodeNumber) {
        assert (pPodcast != null) && (pTitle != null);
        aPodcast = pPodcast;
        aTitle = pTitle.toLowerCase();
        aEpisodeNumber = pEpisodeNumber;
        aPodcast.addEpisode(this);
    }

    public Podcast getaPodcast() {
        return aPodcast;
    }

    public String getaTitle() {
        return aTitle;
    }

    public int getaEpisodeNumber() {
        return aEpisodeNumber;
    }

    /**
     * Returns a Episode based on the current cache of flyweight Episodes
     * 
     * @param pPodcast       Podcast that this episode is a part of
     * 
     * @param pTitle         title of the episode
     * 
     * @param pEpisodeNumber the episode number that identifies the episode
     * 
     * @return Episode object
     */
    public static Episode getEpisode(Podcast pPodcast, String pTitle, int pEpisodeNumber) {

        // Temp Episode object to compare Episode objects in the cache.
        Episode requestedEpisode = new Episode(pPodcast, pTitle, pEpisodeNumber);

        if (episodeCache.isEmpty()) {
            episodeCache.add(requestedEpisode);
            return requestedEpisode;
        }

        // Check the Episode cache to see if the Episode already exists.
        for (int i = 0; i < episodeCache.size(); i++) {
            Episode tempEpisode = episodeCache.get(i);

            // If the Episode already exists return it to the Client.
            if (tempEpisode.equals(requestedEpisode)) {
                return tempEpisode;
            }
        }

        // Episode DNE, therefore add it to cache and return it.
        episodeCache.add(requestedEpisode);

        return requestedEpisode;
    }

    @Override
    public void play() {
        System.out.println("Now playing " + aPodcast.getName() + " [" + aEpisodeNumber + "]: " + aTitle);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + aEpisodeNumber;
        result = prime * result + ((aPodcast == null) ? 0 : aPodcast.hashCode());
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
        Episode other = (Episode) obj;
        if (aEpisodeNumber != other.aEpisodeNumber)
            return false;
        if (aPodcast == null) {
            if (other.aPodcast != null)
                return false;
        } else if (!aPodcast.equals(other.aPodcast))
            return false;
        if (aTitle == null) {
            if (other.aTitle != null)
                return false;
        } else if (!aTitle.equals(other.aTitle))
            return false;
        return true;
    }

}
