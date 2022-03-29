/**
 * @author Diego Dorantes-Ferreira 260854063
 */
public class AddPlayableCommand implements Command {

    private PlayList aPlayList; // Playlist to add to.
    private Playable aPlayable; // Playable to add.

    /**
     * Creates a AddPlayableCommand
     *
     * @param pPlayList the Playlist to add to.
     * @param pPlayable the Playable to add.
     * 
     * @pre pPlayList != null && pPlayList != null;
     */
    public AddPlayableCommand(PlayList pPlayList, Playable pPlayable) {
        assert pPlayList != null && pPlayList != null;
        aPlayList = pPlayList;
        aPlayable = pPlayable;
    }

    /**
     * Adds the stored Playable to the stored Playlist
     */
    @Override
    public void execute() {
        aPlayList.addPlayable(aPlayable);
    }

    /**
     * Removes the previously added Playable from the stored Playlist
     * 
     * @pre aPlayList.IndexOf(aPlayable) != -1;
     */
    @Override
    public void undo() {
        assert aPlayList.IndexOf(aPlayable) != -1;
        aPlayList.removePlayable(aPlayList.IndexOf(aPlayable));

    }

}
