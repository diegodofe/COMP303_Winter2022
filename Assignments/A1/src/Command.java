/**
 * This class helps constuct a Command that will be used by RemoteControl
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */
public class Command {

    // **************************************************
    // Fields
    // **************************************************
    private CommandType type;
    private int distance;
    private String focusObject;
    private FileType fileType;
    private String fileName;

    // **************************************************
    // Overloaded Constructors
    // **************************************************

    /**
     * Constructor for all movement command types (UP, DOWN, FORWARD, BACK).
     */
    Command(CommandType type, int distance) {
        this.type = type;
        this.distance = distance;
    }

    /**
     * Constructor for focusing camera command type (FOCUS).
     */
    Command(CommandType type, String focusObject) {
        this.type = type;
        this.focusObject = focusObject;
    }

    /**
     * Constructor for (CAPTURE) command type for capturing image.
     */
    Command(CommandType type, FileType fileType, String fileName) {
        this.type = type;
        this.fileType = fileType;
        this.fileName = fileName;
    }

    // **************************************************
    // Get methods.
    // **************************************************
    public CommandType getType() {
        return this.type;
    }

    public String getFocusObject() {
        return this.focusObject;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getFileName() {
        return this.fileName;
    }

    public FileType getFileType() {
        return this.fileType;
    }

}
