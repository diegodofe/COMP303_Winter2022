
/**
 * @author Diego Dorantes-Ferreira 260854063
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.LinkedList;

public class TestPlayListInvoker {

    @Test
    public void testSetCurrentCommand() {

        // Arrange
        PlayList myPlayList = new PlayList("Playlist1");
        Song s1 = new Song("Hello", "Adele");

        PlayListInvoker playListInvoker = new PlayListInvoker();
        Command command1 = new AddPlayableCommand(myPlayList, s1);

        // Act
        playListInvoker.setCurrentCommand(command1);
        Command currentCommand = null;
        Class<?> secretClass = playListInvoker.getClass();
        try {
            // Get currentCommand
            Field[] invokerFields = secretClass.getDeclaredFields();
            invokerFields[0].setAccessible(true);
            currentCommand = (Command) invokerFields[0].get(playListInvoker);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(currentCommand, command1);
    }

    @Test
    public void testExecuteCurrentCommand() {
        // Arrange
        PlayList myPlayList = new PlayList("Playlist1");
        Song s1 = new Song("Hello", "Adele");

        PlayListInvoker playListInvoker = new PlayListInvoker();
        Command command1 = new AddPlayableCommand(myPlayList, s1);
        playListInvoker.setCurrentCommand(command1);

        // Act
        playListInvoker.executeCurrentCommand();
        LinkedList<Command> undoList = null;
        Class<?> secretClass = playListInvoker.getClass();
        try {
            // Get undoList
            Field[] invokerFields = secretClass.getDeclaredFields();
            invokerFields[2].setAccessible(true);
            undoList = (LinkedList<Command>) invokerFields[2].get(playListInvoker);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(undoList.getLast(), command1);
    }

    @Test
    public void testUndoCommand() {
        // Arrange
        PlayList myPlayList = new PlayList("Playlist1");
        Song s1 = new Song("Hello", "Adele");

        PlayListInvoker playListInvoker = new PlayListInvoker();
        Command command1 = new AddPlayableCommand(myPlayList, s1);
        playListInvoker.setCurrentCommand(command1);
        playListInvoker.executeCurrentCommand();

        // Act
        playListInvoker.undoCommand();
        LinkedList<Command> redoList = null;
        Class<?> secretClass = playListInvoker.getClass();
        try {
            // Get redoList
            Field[] invokerFields = secretClass.getDeclaredFields();
            invokerFields[1].setAccessible(true);
            redoList = (LinkedList<Command>) invokerFields[1].get(playListInvoker);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(redoList.getLast(), command1);
    }

    @Test
    public void testRedoCommand() {
        // Arrange
        PlayList myPlayList = new PlayList("Playlist1");
        Song s1 = new Song("Hello", "Adele");

        PlayListInvoker playListInvoker = new PlayListInvoker();
        Command command1 = new AddPlayableCommand(myPlayList, s1);
        playListInvoker.setCurrentCommand(command1);
        playListInvoker.executeCurrentCommand();
        playListInvoker.undoCommand();

        // Act
        playListInvoker.redoCommand();
        LinkedList<Command> undoList = null;
        Class<?> secretClass = playListInvoker.getClass();
        try {
            // Get undoList
            Field[] invokerFields = secretClass.getDeclaredFields();
            invokerFields[2].setAccessible(true);
            undoList = (LinkedList<Command>) invokerFields[2].get(playListInvoker);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(undoList.getLast(), command1);
    }
}