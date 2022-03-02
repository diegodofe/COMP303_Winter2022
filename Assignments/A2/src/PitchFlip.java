
/**
 * PitchFlip class implements methods From Trick interface.
 * Creates a specific sequence of movements.
 * For PitchFlip, users can only modify recording and distance.
 * PitchFlip is then passed on to Drone for execution, or can be added to a Flight.
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */

import java.util.ArrayList;

public class PitchFlip implements Trick {

    // **************************************************
    // Fields
    // **************************************************
    final private ArrayList<Movement> moves;
    final private String trickName = "PitchFlip";

    /**
     * Constructor
     *
     * Initializes the specific sequence of moves to perform a PitchFlip trick
     * 
     */
    public PitchFlip() {
        this.moves = new ArrayList<>();
        Movement m1 = new Movement(Direction.FORWARD, Speed.HIGH);
        Movement m2 = new Movement(Direction.UP, Speed.HIGH);
        Movement m3 = new Movement(Direction.FORWARD, Speed.HIGH);
        moves.add(m1);
        moves.add(m2);
        moves.add(m3);
    }

    // **************************************************
    // Overriding methods for PitchFlip to implement Trick
    // interface.
    // Please check Trick interface for documentation.
    // **************************************************

    @Override
    public ArrayList<Movement> getMoves() {
        return new ArrayList<>(moves);
    }

    @Override
    public String getTrickName() {
        return this.trickName;
    }

    @Override
    public void previewMoves() {
        System.out.print("\nPreview " + this.trickName + ":");

        for (int i = 0; i < this.moves.size(); i++) {
            System.out.print("\n" + i + ": " + "Move " + this.moves.get(i).getDirection() + " "
                    + this.moves.get(i).getDistance() + "m at " + this.moves.get(i).getSpeed() + " speed.");
            if (this.moves.get(i).isRecording()) {
                System.out.print(" Record to " + this.moves.get(i).getvFormat() + "...");
            } else {
                System.out.print(" Don't record...");
            }
        }
    }

    @Override
    public void recordMove(int index, VideoFormat vFormat) {
        assert index >= 0 && index < this.moves.size() && vFormat != null;

        this.moves.get(index).setRecording(true);
        this.moves.get(index).setvFormat(vFormat);

    }

    @Override
    public void recordAllMoves(VideoFormat vFormat) {
        assert vFormat != null;

        for (int i = 0; i < this.moves.size(); i++) {
            recordMove(i, vFormat);
        }
    }

    @Override
    public void removeRecording(int index) {
        assert index >= 0 && index < this.moves.size();
        this.moves.get(index).setRecording(false);
        this.moves.get(index).setvFormat(null);

    }

    @Override
    public void removeAllRecordings() {
        for (int i = 0; i < this.moves.size(); i++) {
            removeRecording(i);
        }
    }

    @Override
    public void editDistance(int index, int distance) {
        assert index >= 0 && index < this.moves.size() && distance > 0;

        this.moves.get(index).setDistance(distance);
    }

    @Override
    public void editAllDistance(int distance) {
        assert distance > 0;
        for (int i = 0; i < this.moves.size(); i++) {
            editDistance(i, distance);
        }
    }

}
