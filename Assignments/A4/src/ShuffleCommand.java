/**
 * @author Diego Dorantes-Ferreira 260854063
 */
public class ShuffleCommand implements Command {

    private PlayList aPlayList;
    private PlayList aPreviousPlayList;

    /**
     * Creates a SuffleCommand
     *
     * @param pPlayList the Playlist to shuffle.
     * @pre pPlayList != null;
     */
    public ShuffleCommand(PlayList pPlayList) {
        assert pPlayList != null;
        aPlayList = pPlayList;
    }

    /**
     * Shuffles the stored aPlayList, and saves it's previous state in
     * aPreviousPlayList.
     */
    @Override
    public void execute() {
        aPreviousPlayList = (PlayList) aPlayList.makeCopy();
        aPlayList.shuffle();
    }

    /**
     * Sets aPlayList to the previous state (aPreviousPlayList)
     */
    @Override
    public void undo() {
        aPlayList = aPreviousPlayList;
    }

}
