import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single Podcast, with at least a name and a host. Each Podcast aggregates episodes.
 */
public class Podcast{

    private static final List<Podcast> allPodcasts = new ArrayList<>();
    private final String aName;
    private final String aHost;

    private List<Episode> aEpisodes = new ArrayList<>();

    public static Podcast getPodcast(String aName, String aHost){

        Podcast requestedPodcast = new Podcast(aName, aHost);

        if (allPodcasts.isEmpty()){
            allPodcasts.add(requestedPodcast);
            return requestedPodcast;
        }

        for (int i = 0; i<allPodcasts.size();i++){
            Podcast tempSong = allPodcasts.get(i);
            if (tempSong.equals(requestedPodcast)){
                return tempSong;
            }
        }

        allPodcasts.add(requestedPodcast);
        
        return requestedPodcast;
    }

    /**
     * Creates a Podcast.
     * Add your constructor here
     */
    private Podcast(String pName, String pHost) {
        aName = pName.toLowerCase();
        aHost = pHost.toLowerCase();
    }

    /**
     * Add one episode to the podcast
     * @param pEpisode to be put into the podcast
     * @pre
     */
    protected void addEpisode(Episode pEpisode) {
        if(!aEpisodes.contains(pEpisode)) {
            aEpisodes.add(pEpisode);
        }
    }

    /**
     * retrieve one episode from the podcast
     * @param pIndex
     *
     */

    public Episode getEpisode(int pIndex) {
       //
        return null;
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

    public String getName() {
        return aName;
    }

    public String getHost() {
        return aHost;
    }

}