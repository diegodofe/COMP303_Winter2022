
/**
 * @author Diego Dorantes-Ferreira 260854063
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

public class TestShuffleCommand {

    @Test
    public void testExecute() {

        // Arrange
        PlayList myPlayList = new PlayList("Cool Playlist");
        Song s1 = new Song("Hello", "Adele");
        Song s2 = new Song("Bangerang", "Skrillex");
        Song s3 = new Song("Hey Jude", "The Beatles");

        myPlayList.addPlayable(s1);
        myPlayList.addPlayable(s2);
        myPlayList.addPlayable(s3);

        // Act
        Command shuffleCommand = new ShuffleCommand(myPlayList);
        shuffleCommand.execute();
        PlayList aPlayList = null;
        PlayList aPreviousPlayList = null;
        Class<?> secretClass = shuffleCommand.getClass();
        try {
            // Get aPlayList
            Field[] commandFields = secretClass.getDeclaredFields();
            commandFields[0].setAccessible(true);
            aPlayList = (PlayList) commandFields[0].get(shuffleCommand);

            // Get aPreviousPlayList
            commandFields[1].setAccessible(true);
            aPreviousPlayList = (PlayList) commandFields[1].get(shuffleCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertNotEquals(aPlayList, aPreviousPlayList);
    }

    @Test
    public void testUndo() {

        // Arrange
        PlayList myPlayList = new PlayList("Cool Playlist");
        Song s1 = new Song("Hello", "Adele");
        Song s2 = new Song("Bangerang", "Skrillex");
        Song s3 = new Song("Hey Jude", "The Beatles");

        myPlayList.addPlayable(s1);
        myPlayList.addPlayable(s2);
        myPlayList.addPlayable(s3);

        // Act
        Command shuffleCommand = new ShuffleCommand(myPlayList);
        shuffleCommand.execute();

        PlayList aPreviousPlayList = null;
        Class<?> secretClass = shuffleCommand.getClass();
        try {
            // Get aPreviousPlayList
            Field[] commandFields = secretClass.getDeclaredFields();
            commandFields[1].setAccessible(true);
            aPreviousPlayList = (PlayList) commandFields[1].get(shuffleCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        shuffleCommand.undo();

        PlayList aPlayList = null;
        try {
            // Get aPlayList
            Field[] commandFields = secretClass.getDeclaredFields();
            commandFields[0].setAccessible(true);
            aPlayList = (PlayList) commandFields[0].get(shuffleCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(aPlayList, aPreviousPlayList);
    }
}