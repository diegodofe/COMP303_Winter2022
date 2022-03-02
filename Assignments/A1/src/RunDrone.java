/**
 * Main class to test and showcase the functonality of RemoteControl and Drone
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */
public class RunDrone {
    public static void main(String[] args) throws Exception {

        /**
         * TEST CASE 1: Showcases the user adding movement methods to the sequence and
         * then executing.
         * 
         */
        System.out.println("TEST CASE 1:");
        RemoteControl remote1 = new RemoteControl();
        remote1.addCommand(CommandType.UP, 20);
        remote1.addCommand(CommandType.DOWN, 20);
        remote1.addCommand(CommandType.FORWARD, 20);
        remote1.addCommand(CommandType.BACK, 20);
        remote1.execute();

        /**
         * TEST CASE 2: Showcases the focus command and capture command.
         * 
         */
        System.out.println("\nTEST CASE 2:");
        RemoteControl remote2 = new RemoteControl();
        remote2.addCommand(CommandType.UP, 20);
        remote2.addCommand(CommandType.DOWN, 20);
        remote2.addCommand(CommandType.FOCUS, "tree");
        remote2.addCommand(CommandType.CAPTURE, FileType.PNG, "my-tree");
        remote2.addCommand(CommandType.FORWARD, 20);
        remote2.addCommand(CommandType.BACK, 20);
        remote2.execute();

        /**
         * TEST CASE 3: Showcases adding a command at a specified index, and a failed
         * capture
         * 
         * 
         * User adds a movement command in between the focus and capture commands.
         * As a result, the object becomes out of focus and capture fails.
         * 
         */
        System.out.println("\nTEST CASE 3:");
        RemoteControl remote3 = new RemoteControl();
        remote3.addCommand(CommandType.UP, 20);
        remote3.addCommand(CommandType.DOWN, 20);
        remote3.addCommand(CommandType.FOCUS, "house");
        remote3.addCommand(CommandType.CAPTURE, FileType.RAW, "my-house");
        remote3.addCommand(CommandType.FORWARD, 20);
        remote3.addCommand(CommandType.BACK, 20);
        remote3.addCommand(3, CommandType.UP, 50);
        remote3.execute();

        /**
         * TEST CASE 4: Showcases removing a command and displaying the current
         * sequence.
         * 
         * To make sure not to mess up the photo, user wishes to see the current
         * sequence before executing.
         * 
         * User removes the movement command in between the focus and capture commands.
         * As a result, capture will be successful this time!
         * 
         */
        System.out.println("\nTEST CASE 4:");
        RemoteControl remote4 = new RemoteControl();
        remote4.addCommand(CommandType.UP, 20);
        remote4.addCommand(CommandType.DOWN, 20);
        remote4.addCommand(CommandType.FOCUS, "ferrari");
        remote4.addCommand(CommandType.CAPTURE, FileType.JPG, "not-my-car");
        remote4.addCommand(CommandType.FORWARD, 20);
        remote4.addCommand(CommandType.BACK, 20);
        remote4.addCommand(3, CommandType.UP, 50);

        remote4.printSequence();
        remote4.removeCommand(3);
        remote4.execute();
    }
}
