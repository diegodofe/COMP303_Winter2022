
/**
 * @author Diego Dorantes-Ferreira 260854063
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestDefaultPlayable {

    @Test
    public void testGetDefaultPlayable_NotEmpty() {

        // Arrange
        PlayList myPlayList = new PlayList("Best Songs");
        Song myFirstSong = new Song("Hello", "Adele");
        Song mySecondSong = new Song("Bangerang", "Skrillex");
        myPlayList.addPlayable(myFirstSong);
        myPlayList.addPlayable(mySecondSong);

        // Act
        Library.createLibrary("Diego's Library");
        Library.getLibrary().setDefaultPlayable(myPlayList);

        // Assert
        assertNotNull(Library.getLibrary().getDefaultPlayable());
    }

    @Test
    public void testGetDefaultPlayable_Empty() {

        // Arrange
        Library.createLibrary("Diego's Library");

        // Act
        // Did not set any default Playable

        // Assert
        assertNull(Library.getLibrary().getDefaultPlayable());
    }

    @Test
    public void testGetDefaultPlayable_CorrectReturnType() {
        // Arrange
        PlayList myPlayList = new PlayList("Best Songs");
        Song myFirstSong = new Song("Hello", "Adele");
        Song mySecondSong = new Song("Bangerang", "Skrillex");
        myPlayList.addPlayable(myFirstSong);
        myPlayList.addPlayable(mySecondSong);

        // Act
        Library.createLibrary("Diego's Library");
        Library.getLibrary().setDefaultPlayable(myPlayList);

        // Assert
        assertInstanceOf(Playable.class, Library.getLibrary().getDefaultPlayable());
    }

}