import java.util.*;

/**
 * Represents a sequence of playables to play in FIFO order.
 */
public class PlayList implements Playable {

    private final List<Playable> aList = new LinkedList<>();
    private String aName;
    private int aNext;

    /**
     * Creates a new empty playlist.
     *
     * @param pName the name of the list
     * 
     * @pre pName!=null;
     */
    public PlayList(String pName) {
        assert pName != null;
        aName = pName;
        aNext = 0;
    }

    /**
     * Getter method to iterate over playables. Since playables are immutable,
     * method returns a shallow copy.
     *
     * @return ArrayList of playables
     */
    public List<Playable> getaList() {
        return new ArrayList<>(aList);
    }

    /**
     * Adds a playable at the end of this playlist.
     *
     * @param pPlayable the content to add to the list
     * 
     * @pre pPlayable!=null;
     */
    public void addPlayable(Playable pPlayable) {
        assert pPlayable != null;
        aList.add(pPlayable);
    }

    @Override
    public void play() {
        for (Playable playable : aList) {
            playable.play();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aList == null) ? 0 : aList.hashCode());
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
        PlayList other = (PlayList) obj;
        if (aList == null) {
            if (other.aList != null)
                return false;
        } else if (!aList.equals(other.aList))
            return false;
        return true;
    }
}
