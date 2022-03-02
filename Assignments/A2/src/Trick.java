
/**
 * Interface to be implemented by the other types of Tricks.
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */

import java.util.ArrayList;

public interface Trick {

    /**
     * Returns name of trick.
     */
    String getTrickName();

    /**
     * Returns shallow copy of sequence of moves to execute for Drone class.
     */
    ArrayList<Movement> getMoves();

    /**
     * Prints the current sequence of moves in Trick.
     */
    void previewMoves();

    /**
     * Allows user to record a specific movement in Trick.
     * 
     * @param index   is the index in the Trick list of movements.
     * @param vFormat is the desired video format for the chosen movement.
     */
    void recordMove(int index, VideoFormat vFormat);

    /**
     * Allows user to not record a specific movement in Trick.
     * 
     * @param index is the index in the Trick list of movements.
     */
    void removeRecording(int index);

    /**
     * Allows user to record all moves in a Trick.
     * 
     * @param vFormat is the desired video format for all the moves in Trick.
     */
    void recordAllMoves(VideoFormat vFormat);

    /**
     * Allows user to choose not to record all moves in a Trick.
     */
    void removeAllRecordings();

    /**
     * Allows user to modify a specific movement's distance in a Trick.
     * 
     * @param index    is the index in the Trick list of movements.
     * @param distance is the new desired distance for the chosen movement.
     */
    void editDistance(int index, int distance);

    /**
     * Allows user to modify all the movement's distance in a Trick.
     * 
     * @param distance is the new desired distance for all movements.
     */
    void editAllDistance(int distance);
}
