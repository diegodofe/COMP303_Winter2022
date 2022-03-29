import java.io.Serializable;

/**
 * @author Diego Dorantes-Ferreira 260854063
 */

/**
 * Represents an audio object that can be played
 */
interface Playable extends Serializable {

    /**
     * Plays the audio to the user
     */
    void play();

    Playable makeCopy();
}