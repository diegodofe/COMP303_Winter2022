
/**
 * @author Diego Dorantes-Ferreira 260854063
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

public class TestAddPlayableCommand {

    @Test
    public void testExecute() {

        // Arrange
        PlayList myPlayList = new PlayList("Cool Playlist");
        Song s1 = new Song("Hello", "Adele");

        // Act
        Command addPlayableCommand = new AddPlayableCommand(myPlayList, s1);
        addPlayableCommand.execute();

        PlayList aPlayList = null;
        Class<?> secretClass = addPlayableCommand.getClass();
        try {
            // Get aPlayList
            Field[] commandFields = secretClass.getDeclaredFields();
            commandFields[0].setAccessible(true);
            aPlayList = (PlayList) commandFields[0].get(addPlayableCommand);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(aPlayList.IndexOf(s1), 0);

    }

    @Test
    public void testUndo() {

        // Arrange
        PlayList myPlayList = new PlayList("Cool Playlist");
        Song s1 = new Song("Hello", "Adele");

        // Act
        Command addPlayableCommand = new AddPlayableCommand(myPlayList, s1);
        addPlayableCommand.execute();
        addPlayableCommand.undo();

        PlayList aPlayList = null;
        Class<?> secretClass = addPlayableCommand.getClass();
        try {
            // Get aPlayList
            Field[] commandFields = secretClass.getDeclaredFields();
            commandFields[0].setAccessible(true);
            aPlayList = (PlayList) commandFields[0].get(addPlayableCommand);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(aPlayList.IndexOf(s1), -1);

    }

}