import java.util.*;

/**
 * Represents a single Podcast, with at least a name and a host. Each Podcast
 * aggregates episodes.
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */
public class Podcast {

    // Cache of current flyweight Podcasts.
    private static final List<Podcast> podcastCache = new ArrayList<>();

    private final String aName;
    private final String aHost;
    private final List<Episode> aEpisodes = new ArrayList<>();

    /**
     * Creates a Podcast. Private constructor that is only called from getPodcast()
     * method.
     *
     * @pre pName != null && pHost!=null
     * @throws IllegalArgumentException
     */
    private Podcast(String pName, String pHost) {

        assert (pName != null) && (pHost != null);

        aName = pName.toLowerCase();
        aHost = pHost.toLowerCase();
    }

    public String getName() {
        return aName;
    }

    public String getHost() {
        return aHost;
    }

    /**
     * Returns a song based on the current cache of flyweight podcast
     * 
     * @param pTitle  title of the episode
     * @param pArtist artist name of the song
     * @return Podcast object
     */
    public static Podcast getPodcast(String aName, String aHost) {

        // Temp Podcast object to compare Podcast objects in the cache.
        Podcast requestedPodcast = new Podcast(aName, aHost);

        if (podcastCache.isEmpty()) {
            podcastCache.add(requestedPodcast);
            return requestedPodcast;
        }

        // Check the Podcast cache to see if the song already exists.
        for (int i = 0; i < podcastCache.size(); i++) {
            Podcast tempSong = podcastCache.get(i);

            // If the Podcast already exists return it to the Client.
            if (tempSong.equals(requestedPodcast)) {
                return tempSong;
            }
        }

        // Podcast DNE, therefore add it to cache and return it.
        podcastCache.add(requestedPodcast);

        return requestedPodcast;
    }

    /**
     * Determines number of episodes in this Podcast
     * 
     * @returns size of aEpisode
     */
    public int getNumEpisodes() {
        return aEpisodes.size();
    }

    /**
     * retrieve one episode from the podcast
     * 
     * @param pIndex
     * 
     * @pre pIndex >= 0 && pIndex < aEpisodes.size() && getNumEpisodes() > 0
     * @throws IllegalArgumentException
     * @returns Episode object
     */
    public Episode getEpisode(int pIndex) {

        assert (!aEpisodes.isEmpty()) && (pIndex >= 0) && (pIndex < aEpisodes.size());

        return aEpisodes.get(pIndex);

    }

    /**
     * Prints current list of episodes in this Podcast.
     */
    public void episodeList() {
        for (int i = 0; i < aEpisodes.size(); i++) {
            System.out.println(
                    i + ": " + " [" + aEpisodes.get(i).getaEpisodeNumber() + "]: " + aEpisodes.get(i).getaTitle());
        }
    }

    /**
     * Add one episode to the podcast
     * 
     * @param pEpisode to be put into the podcast
     * @pre
     */
    protected void addEpisode(Episode pEpisode) {
        if (!aEpisodes.contains(pEpisode)) {
            aEpisodes.add(pEpisode);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aHost == null) ? 0 : aHost.hashCode());
        result = prime * result + ((aName == null) ? 0 : aName.hashCode());
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
        Podcast other = (Podcast) obj;
        if (aHost == null) {
            if (other.aHost != null)
                return false;
        } else if (!aHost.equals(other.aHost))
            return false;
        if (aName == null) {
            if (other.aName != null)
                return false;
        } else if (!aName.equals(other.aName))
            return false;
        return true;
    }

}