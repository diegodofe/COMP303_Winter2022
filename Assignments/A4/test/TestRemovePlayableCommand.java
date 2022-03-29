
/**
 * @author Diego Dorantes-Ferreira 260854063
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

public class TestRemovePlayableCommand {

    @Test
    public void testExecute() {

        // Arrange
        PlayList myPlayList = new PlayList("Cool Playlist");
        Song s1 = new Song("Hello", "Adele");
        myPlayList.addPlayable(s1);

        // Act
        Command removePlayableCommand = new RemovePlayableCommand(myPlayList, 0);
        removePlayableCommand.execute();

        PlayList aPlayList = null;
        Class<?> secretClass = removePlayableCommand.getClass();
        try {
            // Get aPlayList
            Field[] commandFields = secretClass.getDeclaredFields();
            commandFields[0].setAccessible(true);
            aPlayList = (PlayList) commandFields[0].get(removePlayableCommand);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(aPlayList.IndexOf(s1), -1);

    }

    @Test
    public void testUndo() {

        // Arrange
        PlayList myPlayList = new PlayList("Cool Playlist");
        Song s1 = new Song("Hello", "Adele");
        myPlayList.addPlayable(s1);

        // Act
        Command removePlayableCommand = new RemovePlayableCommand(myPlayList, 0);
        removePlayableCommand.execute();
        removePlayableCommand.undo();

        PlayList aPlayList = null;
        Class<?> secretClass = removePlayableCommand.getClass();
        try {
            // Get aPlayList
            Field[] commandFields = secretClass.getDeclaredFields();
            commandFields[0].setAccessible(true);
            aPlayList = (PlayList) commandFields[0].get(removePlayableCommand);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(aPlayList.IndexOf(s1), 0);

    }

}