/**
 * Drone class for user to execute movements, tricks, and flights.
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */
public class Drone {

    // **************************************************
    // Fields
    // **************************************************
    final private String name;
    private Direction direction;
    private Speed speed;
    private int distance;

    public Drone(String name) {
        this.name = name;
        this.direction = null;
        this.speed = null;
        this.distance = 0;
    }

    // ****************************************************************
    // Executables. Allows user to execute their movements, trick, or
    // flight on the drone.
    // ****************************************************************

    /**
     * Method to execute a movement on drone.
     *
     * @param m is the movement to execute.
     * 
     */
    public void executeMovement(Movement m) {

        assert m != null;

        this.direction = m.getDirection();
        this.distance = m.getDistance();
        this.speed = m.getSpeed();
        System.out.print(
                "\n" + this.name + " moving " + this.direction + " " + this.distance + "m at " + this.speed
                        + " speed.");

        if (m.isRecording()) {
            System.out.print(" Recorded to " + m.getvFormat() + "!");
        } else {
            System.out.print(" Not recorded!");
        }
    }

    /**
     * Method to execute a trick on drone.
     *
     * @param trick is the trick to execute.
     * 
     */
    public void executeTrick(Trick trick) {
        assert trick != null;

        System.out.print("\nExecuting " + trick.getTrickName() + ":");
        for (Movement m : trick.getMoves()) {
            executeMovement(m);
        }
    }

    /**
     * Method to execute a flight on drone.
     *
     * @param flight is the flight to execute.
     * 
     */
    public void executeFlight(Flight flight) {
        assert flight != null;

        System.out.print("\nEXECUTING FLIGHT:");
        for (Trick t : flight.getTricks()) {
            executeTrick(t);
            System.out.println();
        }
    }
}
