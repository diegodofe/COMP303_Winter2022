/**
 * @author Diego Dorantes-Ferreira 260854063
 */
public class SetNameCommand implements Command {
    private PlayList aPlayList;
    private String aName;
    private String aPreviousName;

    /**
     * Creates a SetNameCommand
     *
     * @param pPlayList the Playlist to set name to.
     * @param pName     the new name to set.
     * 
     * @pre pPlayList != null && pName != null;
     */
    public SetNameCommand(PlayList pPlayList, String pName) {
        assert pPlayList != null && pName != null;
        aPlayList = pPlayList;
        aName = pName;
    }

    /**
     * Modifies the name of the playlist using the stored aName. Stores the previous
     * name in aPreviousName.
     */
    @Override
    public void execute() {
        aPreviousName = aPlayList.getName();
        aPlayList.setName(aName);
    }

    /**
     * Modifies the name of the playlist using the aPreviousName.
     */
    @Override
    public void undo() {
        aPlayList.setName(aPreviousName);
    }

}
