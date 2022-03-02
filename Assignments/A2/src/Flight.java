
/**
 * Flight class allows users to group ticks, to then pass on to Drone for execution.
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */

import java.util.HashSet;
import java.util.LinkedList;

public class Flight {

    // **************************************************
    // Fields
    // **************************************************
    final private LinkedList<Trick> tricks;
    final private HashSet<Direction> uniqueDirections;

    /**
     * Constructor.
     *
     * Initializes list of Tricks and list of unique Directions.
     */
    public Flight() {
        this.uniqueDirections = new HashSet<>();
        this.tricks = new LinkedList<>();
    }

    /**
     * Overriding method that allows user to add a Trick to the Flight.
     *
     * @param trick is the new trick to be added to the Flight.
     * 
     */
    public void addTrick(Trick trick) {
        assert trick != null;

        this.tricks.add(trick);
    }

    /**
     * Overriding method that allows user to add a Trick to the Flight.
     *
     * @param index is the position to add the new Trick into the list of Tricks.
     * @param trick is the new trick to be added to the Flight.
     * 
     */
    public void addTrick(int index, Trick trick) {
        assert index >= 0 && index < tricks.size() && trick != null;

        this.tricks.add(index, trick);
    }

    /**
     * Overriding method that allows user to remove a Trick to the Flight.
     *
     * @param index is the position to remove a Trick from the list of Tricks.
     * 
     */
    public void removeTrick(int index) {
        assert index >= 0 && index < tricks.size();

        this.tricks.remove(index);
    }

    /**
     * Returns shallow copy of sequence of moves to execute for Drone class.
     */
    public LinkedList<Trick> getTricks() {
        return new LinkedList<>(tricks);
    }

    /**
     * Prints the current sequence of Tricks in Flight.
     */
    public void previewFlight() {
        System.out.print("\nPREVIEW FLIGHT:");

        for (int i = 0; i < this.tricks.size(); i++) {
            System.out.print("\n" + i + ": " + tricks.get(i).getTrickName());
        }
    }

    /**
     * Determines the number of unique Directions in this Flight.
     */
    public int queryFlight() {
        for (Trick t : this.tricks) {
            for (Movement m : t.getMoves()) {
                if (!uniqueDirections.contains(m.getDirection())) {
                    uniqueDirections.add(m.getDirection());
                }
            }
        }

        return uniqueDirections.size();
    }

    /**
     * Determines the number of unique Movements in this Flight.
     */
    public int queryFlightUniqueMovements() {

        LinkedList<Movement> uniqueMoves = new LinkedList<>();

        for (Trick t : this.tricks) {
            for (Movement currentMove : t.getMoves()) {
                boolean isUnique = true;
                for (Movement uniqueMove : uniqueMoves) {
                    if (currentMove.equals(uniqueMove)) {
                        isUnique = false;
                    }
                }
                if (isUnique) {
                    uniqueMoves.add(currentMove);
                }
            }
        }
        return uniqueMoves.size();
    }
}
