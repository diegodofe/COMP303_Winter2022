
/**
 * Run drone! Contains many showcase test cases.
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RunDrone {
    public static void main(String args[]) {

        /**
         * TEST CASE 1: Showcases creating movements in different ways, and executing
         * movements using Drone.
         * 
         * 
         * User creates a bunch of different movements. Some movements do not
         * specify all the attributes, and so, default values will kick in.
         * (Please refer to Movement class to see all default values).
         * 
         * User then executes all of the movements using Drone.
         */
        System.out.println("TEST CASE 1:");

        Drone drone1 = new Drone("Drone1");

        Movement m1 = new Movement(Direction.UP);
        Movement m2 = new Movement(Direction.LEFT, Speed.HIGH, VideoFormat.FLV);
        Movement m3 = new Movement(Direction.RIGHT, Speed.MODERATE, 300);
        Movement m4 = new Movement(Direction.DOWN, 500, VideoFormat.MP4);

        drone1.executeMovement(m1);
        drone1.executeMovement(m2);
        drone1.executeMovement(m3);
        drone1.executeMovement(m4);

        /**
         * TEST CASE 2: Showcases TakeOff trick and modifying movements in TakeOff.
         * 
         * 
         * User creates a new trick call TakeOff.
         * 
         * By default, tricks are not recorded, and so, the user decides record all the
         * moves.
         * 
         * User also decides to modify the distance of one of the moves.
         * 
         */
        System.out.println("\n\n\nTEST CASE 2:");

        Drone drone2 = new Drone("Drone2");
        TakeOff takeOff = new TakeOff();

        takeOff.previewMoves();
        takeOff.recordAllMoves(VideoFormat.WMV);
        takeOff.editDistance(0, 1000);

        System.out.println();
        drone2.executeTrick(takeOff);

        /**
         * TEST CASE 3: Showcases the Pucker trick and modifying movements in Pucker.
         * 
         * 
         * User creates a new trick called Pucker.
         * 
         * User is feeling risky, so he increases the distance and speed of all the
         * moves. User definetly wants to record all of this.
         * 
         * 
         * User then decides to slow down a specific movement, decrease the distance,
         * and remove recording.
         * 
         */
        System.out.println("\n\n\nTEST CASE 3:");

        Drone drone3 = new Drone("Drone3");
        Pucker pucker = new Pucker();

        pucker.editAllDistance(1000);
        pucker.editAllSpeed(Speed.HIGH);
        pucker.recordAllMoves(VideoFormat.AVI);
        pucker.previewMoves();
        pucker.editDistance(4, 300);
        pucker.editSpeed(4, Speed.LOW);
        pucker.removeRecording(4);

        System.out.println();
        drone3.executeTrick(pucker);

        /**
         * TEST CASE 4: Creating, modifying, and executing a Flight.
         * 
         * 
         * User creates a new Flight using the previous Tricks (TakeOff and Pucker).
         * 
         * User insert a new Trick into Flight called PitchFlips.
         * 
         */
        System.out.println("\n\n\nTEST CASE 4:");

        Drone drone4 = new Drone("Drone4");
        PitchFlip pitchFlip = new PitchFlip();
        Flight flight1 = new Flight();

        flight1.addTrick(takeOff);
        flight1.addTrick(pucker);
        flight1.addTrick(1, pitchFlip);
        flight1.previewFlight();

        System.out.println();
        drone4.executeFlight(flight1);

        /**
         * TEST CASE 5: Comparing Flights and sorting using different comparison
         * methods.
         * 
         * 
         * User creates a two new Flights called flight2 and flight3
         * User then adds default tricks to these Flights.
         * 
         * User uses flight1 from the previous tests. Flight1 has 3 tricks, but a lot of
         * the movements have been altered throughout the program. Therefore, flight1
         * should have more unique movements.
         * 
         */
        System.out.println("\n\n\nTEST CASE 5:");

        // Create flight2 and add default Tricks.
        Flight flight2 = new Flight();
        flight2.addTrick(new TakeOff());
        flight2.addTrick(new PitchFlip());
        flight2.addTrick(new Pucker());
        flight2.addTrick(new Pucker());

        // Create flight3 and add default Tricks.
        Flight flight3 = new Flight();
        flight3.addTrick(new TakeOff());

        // Create list of Flights.
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        // Print current unsorted list.
        System.out.println("Current unsorted list of flights:");
        System.out.println(flights.toString());
        System.out.println();

        // Sort using CompareByNumTricks() and print result.
        System.out.println("Sorted by Number of Tricks:");
        Comparator<Flight> compareByTricks = new CompareByNumTricks();
        Collections.sort(flights, compareByTricks);
        for (Flight f : flights) {
            System.out.println(f.toString() + " number of tricks equals " + f.getTricks().size());
        }

        // Sort using CompareByUniqueMovements() and print result.
        System.out.println();
        Comparator<Flight> compareByUniqueMovements = new CompareByUniqueMovements();
        Collections.sort(flights, compareByUniqueMovements);
        System.out.println("Sorted by Unique Movements:");
        for (Flight f : flights) {
            System.out.println(f.toString() + " number of unique moves equals " + f.queryFlightUniqueMovements());
        }
    }
}
