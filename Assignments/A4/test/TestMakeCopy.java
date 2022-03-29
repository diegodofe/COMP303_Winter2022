
/**
 * @author Diego Dorantes-Ferreira 260854063
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestMakeCopy {

    @Test
    public void testSongClone() {

        // Arrange
        Song mySong = new Song("Hello", "Adele");

        // Act
        Song clonedMySong = (Song) mySong.makeCopy();

        // Assert
        assertEquals(mySong, clonedMySong);
    }

    @Test
    public void testPlaylistClone() {

        // Arrange
        PlayList myPlayList = new PlayList("Best Songs");
        Song myFirstSong = new Song("Hello", "Adele");
        Song mySecondSong = new Song("Bangerang", "Skrillex");
        myPlayList.addPlayable(myFirstSong);
        myPlayList.addPlayable(mySecondSong);

        // Act
        PlayList clonedMyPlaylist = (PlayList) myPlayList.makeCopy();

        // Assert
        assertEquals(myPlayList, clonedMyPlaylist);

    }

}