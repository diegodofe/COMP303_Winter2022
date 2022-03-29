
/**
 * @author Diego Dorantes-Ferreira 260854063
 */
import java.util.LinkedList;

public class PlayListInvoker {

    private Command currentCommand; // Current Commands to execute.
    private LinkedList<Command> redoList = new LinkedList<>(); // List of Commands to redo.
    private LinkedList<Command> undoList = new LinkedList<>(); // List of Commands to undo.

    /**
     * Creates a library with description
     *
     * @param pCommand the Command to store
     * 
     * @pre pCommand!=null;
     */
    void setCurrentCommand(Command pCommand) {
        assert pCommand != null;
        currentCommand = pCommand;
    }

    /**
     * Executes the Command stored in currentCommand and adds it to the undoList.
     */
    void executeCurrentCommand() {
        currentCommand.execute();
        undoList.add(currentCommand);
    }

    /**
     * Executes the last Command stored in undoList and adds it to the redoList.
     */
    void undoCommand() {
        undoList.getLast().undo();
        redoList.add(undoList.getLast());
        undoList.removeLast();
    }

    /**
     * Executes the last Command stored in redoList and adds it to back the
     * undoList.
     */
    void redoCommand() {

        // If there are no more Commands left, executing currentCommand.
        if (redoList.size() == 0) {
            executeCurrentCommand();

            // Else, keep executing the Commands store in redoList.
        } else {
            redoList.getLast().execute();
            undoList.add(currentCommand);
            redoList.removeLast();
        }
    }

}
