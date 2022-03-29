/**
 * @author Diego Dorantes-Ferreira 260854063
 */
public class RemovePlayableCommand implements Command {

    private PlayList aPlayList;
    private int aIndex;
    private Playable aRemovedPlayable;

    /**
     * Creates a RemovePlayableCommand
     *
     * @param pPlayList the Playlist to remove to.
     * @param pIndex    the index of the Playable to remove.
     * 
     * @pre pPlayList != null && pIndex >= 0;
     */
    public RemovePlayableCommand(PlayList pPlayList, int pIndex) {
        assert pPlayList != null && pIndex >= 0;
        aPlayList = pPlayList;
        aIndex = pIndex;
    }

    /**
     * Removes the Playable from the Playlist using the stored index, and stores it
     * in aRemovedPlayable.
     */
    @Override
    public void execute() {
        aRemovedPlayable = aPlayList.removePlayable(aIndex);
    }

    /**
     * Adds the Playable stored in aRemovedPlayable into aPlaylist.
     */
    @Override
    public void undo() {
        aPlayList.addPlayable(aRemovedPlayable);
    }
}
