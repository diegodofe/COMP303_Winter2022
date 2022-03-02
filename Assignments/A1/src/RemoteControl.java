
/**
 * This class creates a Drone object to control using a sequence of commands
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */

import java.util.*;

public class RemoteControl {

    // **************************************************
    // Fields
    // **************************************************
    private String inFocus = null;
    private final Drone myDrone = new Drone();
    private final LinkedList<Command> sequence = new LinkedList<>();

    // ****************************************************************
    // Private methods to manipulate Drone once sequence is executed.
    // Calls set and get methods in Drone, and updated accordingly.
    // ****************************************************************

    private void takeOff() {
        this.myDrone.setInAir(true);
        System.out.println("Taking off...");
    }

    private void land() {
        // Reinitialize drone
        this.myDrone.setInAir(false);
        this.myDrone.setUp(0);
        this.myDrone.setDown(0);
        this.myDrone.setForward(0);
        this.myDrone.setBack(0);
        System.out.println("Landing...");
    }

    private void focus(String focusObject) {
        this.inFocus = focusObject;
        System.out.println("Focusing camera on " + focusObject + "...");
    }

    public void capture(FileType fileType, String name) {
        if (inFocus != null) {
            System.out.println("Captured photo of " + this.inFocus + "! Saved as " + name + "." + fileType);
        } else {
            System.out.println("Capture failed! Was not in focus!");
        }
    }

    private void moveUp(int distance) {
        if (this.myDrone.getInAir()) {
            this.inFocus = null; // Object that was in focus is no longer in focus because we moved.
            int current = this.myDrone.getUp();
            this.myDrone.setUp(current + distance);
            System.out.println("Moving up " + distance + "m");
        }
    };

    private void moveDown(int distance) {
        if (this.myDrone.getInAir()) {
            this.inFocus = null; // Object that was in focus is no longer in focus because we moved.
            int current = this.myDrone.getDown();
            this.myDrone.setDown(current + distance);
            System.out.println("Moving down " + distance + "m");
        }
    };

    private void moveForward(int distance) {
        if (this.myDrone.getInAir()) {
            this.inFocus = null; // Object that was in focus is no longer in focus because we moved.
            int current = this.myDrone.getForward();
            this.myDrone.setForward(current + distance);
            System.out.println("Moving forward " + distance + "m");
        }
    };

    private void moveBack(int distance) {
        if (this.myDrone.getInAir()) {
            this.inFocus = null; // Object that was in focus is no longer in focus because we moved.
            int current = this.myDrone.getBack();
            this.myDrone.setBack(current + distance);
            System.out.println("Moving back " + distance + "m");
        }
    }

    private void checkDistance(int distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Error! Expected distance to be greater than zero.");
        }
    }

    // ****************************************************************
    // Overloaded addCommand methods for RemoteControl user interface
    // ****************************************************************

    /**
     * User interface method to add a movement command the sequence list.
     *
     * @param type     is checked manually. Exception is throw manually.
     * @param distance is checked manually. Exception is throw manually.
     * 
     */
    public void addCommand(CommandType type, int distance) {
        if (type != CommandType.FOCUS && type != CommandType.CAPTURE) {
            checkDistance(distance);
            Command c = new Command(type, distance);
            this.sequence.add(c);
        } else {
            throw new IllegalArgumentException("Error! " + "Expected either: " + CommandType.UP + ", "
                    + CommandType.DOWN + ", " + CommandType.FOCUS + ", " + CommandType.BACK + ". Received: " + type);
        }
    }

    /**
     * User interface method to add a focus command the sequence list.
     * 
     * @param type        is checked manually. Exception is throw manually.
     * @param focusObject is the object the user wishes to focus on.
     * 
     */
    public void addCommand(CommandType type, String focusObject) {
        if (type == CommandType.FOCUS) {
            Command c = new Command(type, focusObject);
            this.sequence.add(c);
        } else {
            throw new IllegalArgumentException("Error! " + "Expected: " + CommandType.FOCUS + ". Received: " + type);
        }
    }

    /**
     * User interface method to add a capture command the sequence list.
     * 
     * @param type     is checked manually. Exception is throw manually.
     * @param fileType is automatically enfored using the enums.
     * @param fileName is the name for their picture.
     * 
     */
    public void addCommand(CommandType type, FileType fileType, String fileName) {
        if (type == CommandType.CAPTURE) {
            Command c = new Command(type, fileType, fileName);
            this.sequence.add(c);
        } else {
            throw new IllegalArgumentException("Error! " + "Expected: " + CommandType.CAPTURE + ". Received: " + type);
        }
    }

    /**
     * User interface method to add a movement command the sequence list AT SPECIFIC
     * INDEX.
     * 
     * @param index    is automatically checked by compiller.
     *                 Exception is thrown automatically.
     * 
     * @param type     is checked manually. Exception is throw manually.
     * @param distance is checked manually. Exception is throw manually.
     * 
     */
    public void addCommand(int index, CommandType type, int distance) {
        if (type != CommandType.FOCUS && type != CommandType.CAPTURE) {
            checkDistance(distance);
            Command c = new Command(type, distance);
            this.sequence.add(index, c);
        } else {
            throw new IllegalArgumentException("Error! " + "Expected either: " + CommandType.UP + ", "
                    + CommandType.DOWN + ", " + CommandType.FOCUS + ", " + CommandType.BACK + ". Received: " + type);
        }
    }

    /**
     * User interface method to add a focus command the sequence list AT SPECIFIC
     * INDEX.
     * 
     * @param index       is automatically checked by compiller.
     *                    Exception is thrown automatically.
     * 
     * @param type        is checked manually. Exception is throw manually.
     * @param focusObject is the object the user wishes to focus on.
     * 
     */
    public void addCommand(int index, CommandType type, String focusObject) {
        if (type == CommandType.FOCUS) {
            Command c = new Command(type, focusObject);
            this.sequence.add(index, c);
        } else {
            throw new IllegalArgumentException("Error! " + "Expected: " + CommandType.FOCUS + ". Received: " + type);
        }
    }

    /**
     * User interface method to add a capture command the sequence list AT SPECIFIC
     * INDEX.
     * 
     * @param index    is automatically checked by compiller.
     *                 Exception is thrown automatically.
     * 
     * @param type     is checked manually. Exception is throw manually.
     * @param fileType is automatically enfored using the enums.
     * @param fileName is the name for their picture.
     * 
     */
    public void addCommand(int index, CommandType type, FileType fileType, String fileName) {
        if (type == CommandType.CAPTURE) {
            Command c = new Command(type, fileType, fileName);
            this.sequence.add(index, c);
        } else {
            throw new IllegalArgumentException("Error! " + "Expected: " + CommandType.CAPTURE + ". Received: " + type);
        }
    }

    /**
     * User interface method to remove a command the sequence list.
     * 
     * @param index is automatically checked by compiller.
     *              Exception is thrown automatically.
     * 
     */
    public void removeCommand(int index) {
        System.out.println("Removing " + this.sequence.get(index).getType() + " at index " + index + "...\n");
        this.sequence.remove(index);
    }

    /**
     * User interface method to execute the current sequence list.
     */
    public void execute() {

        takeOff();

        for (Command c : this.sequence) {
            switch (c.getType()) {

                case FOCUS:
                    focus(c.getFocusObject());
                    break;
                case CAPTURE:
                    capture(c.getFileType(), c.getFileName());
                    break;
                case UP:
                    moveUp(c.getDistance());
                    break;
                case DOWN:
                    moveDown(c.getDistance());
                    break;
                case FORWARD:
                    moveForward(c.getDistance());
                    break;
                case BACK:
                    moveBack(c.getDistance());
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }

        land();
    };

    /**
     * User interface method to display the current sequence list.
     */
    public void printSequence() {
        System.out.println("Current sequence:");
        for (int i = 0; i < this.sequence.size(); i++) {
            System.out.println(i + ": " + sequence.get(i).getType());
        }
        System.out.println();
    }

}