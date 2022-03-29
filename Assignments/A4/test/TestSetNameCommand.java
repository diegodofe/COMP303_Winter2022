
/**
 * @author Diego Dorantes-Ferreira 260854063
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

public class TestSetNameCommand {

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
        Command setNameCommand = new SetNameCommand(myPlayList, "Diego's Playlist");
        setNameCommand.execute();
        String aName = null;
        String aPreviousName = null;
        Class<?> secretClass = setNameCommand.getClass();
        try {
            // Get aName
            Field[] commandFields = secretClass.getDeclaredFields();
            commandFields[1].setAccessible(true);
            aName = (String) commandFields[1].get(setNameCommand);

            // Get aPreviousName
            commandFields[2].setAccessible(true);
            aPreviousName = (String) commandFields[2].get(setNameCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertNotEquals(aName, aPreviousName);
    }

    @Test
    public void Undo() {

        // Arrange
        PlayList myPlayList = new PlayList("Cool Playlist");
        Song s1 = new Song("Hello", "Adele");
        Song s2 = new Song("Bangerang", "Skrillex");
        Song s3 = new Song("Hey Jude", "The Beatles");

        myPlayList.addPlayable(s1);
        myPlayList.addPlayable(s2);
        myPlayList.addPlayable(s3);

        // Act
        Command setNameCommand = new SetNameCommand(myPlayList, "Diego's Playlist");
        setNameCommand.execute();

        String aPreviousName = null;
        Class<?> secretClass = setNameCommand.getClass();
        try {
            // Get aPreviousName
            Field[] commandFields = secretClass.getDeclaredFields();
            commandFields[2].setAccessible(true);
            aPreviousName = (String) commandFields[2].get(setNameCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setNameCommand.undo();

        PlayList aPlayList = null;
        try {
            // Get aName
            Field[] commandFields = secretClass.getDeclaredFields();
            commandFields[0].setAccessible(true);
            aPlayList = (PlayList) commandFields[0].get(setNameCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals(aPlayList.getName(), aPreviousName);
    }

}