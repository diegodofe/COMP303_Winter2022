import java.io.*;
import java.util.*;

/**
 * @author Diego Dorantes-Ferreira 260854063
 */

/**
 * Represents a sequence of playables to play in FIFO order.
 */
public class PlayList implements Playable {

    private List<Playable> aList = new LinkedList<>();
    private String aName;

    /**
     * Creates a new empty playlist.
     *
     * @param pName
     *              the name of the list
     * @pre pName!=null;
     */
    public PlayList(String pName) {
        assert pName != null;
        aName = pName;
    }

    /**
     * Adds a playable at the end of this playlist.
     *
     * @param pPlayable
     *                  the content to add to the list
     * @pre pPlayable!=null;
     */
    public void addPlayable(Playable pPlayable) {
        assert pPlayable != null;
        aList.add(pPlayable);
    }

    /**
     * remove a playable from the Playlist given its index
     * 
     * @param pIndex
     *               the index of playable to be removed
     * @return the removed playable
     */
    public Playable removePlayable(int pIndex) {
        assert pIndex >= 0 && pIndex < aList.size();
        return aList.remove(pIndex);
    }

    /**
     * @return The name of the playlist.
     */
    public String getName() {
        return aName;
    }

    /**
     * modify the name of the playlist
     * 
     * @param pName
     *              the new name of the playlist
     */
    public void setName(String pName) {
        assert pName != null;
        this.aName = pName;
    }

    /**
     * Iterating through the playlist to play playable content.
     */
    @Override
    public void play() {
        for (Playable playable : aList) {
            playable.play();
        }
    }

    /**
     * change the order how playlist play the playables it contains
     */
    public void shuffle() {
        Collections.shuffle(aList);
    }

    /**
     * Checks is two playlists are equal based on playable objects and their order
     *
     * @param o
     *          The object to compare a playlist to
     * @return This method returns true if the playlist is the same as the obj
     *         argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PlayList playList = (PlayList) o;
        return this.aList.equals(playList.aList);
    }

    /**
     * Equal playlists have the same hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(aList);
    }

    /**
     * Creates and returns a copy of this Playlist object
     *
     * @return This method returns a cloned Playlist object
     */
    @Override
    public Playable makeCopy() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (Playable) ois.readObject();
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public int IndexOf(Playable aPlayable) {
        return aList.indexOf(aPlayable);
    }

}
