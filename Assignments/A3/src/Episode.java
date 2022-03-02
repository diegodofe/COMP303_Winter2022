/**
 * Represents a single episode, with at least a title, and an episode number.
 */
public class Episode implements Playable {

    private final Podcast aPodcast;
    private final String aTitle;
    private final int aEpisodeNumber;

    /**
     * Creates an episode
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
    Episode(Podcast pPodcast, String pTitle, int pEpisodeNumber) {
        assert (pPodcast != null) && (pTitle != null);
        aPodcast = pPodcast;
        aTitle = pTitle;
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
