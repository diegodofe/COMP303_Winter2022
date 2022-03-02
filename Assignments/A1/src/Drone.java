/**
 * Drone class that will be updated by RemoteControl.
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */
public class Drone {

    // **************************************************
    // Fields
    // **************************************************
    private int up;
    private int down;
    private int forward;
    private int back;
    private boolean inAir;

    /**
     * Default constructor.
     */
    Drone() {
        this.up = 0;
        this.down = 0;
        this.forward = 0;
        this.back = 0;
        this.inAir = false;
    }

    // **************************************************
    // Get methods.
    // **************************************************
    public int getUp() {
        return this.up;
    }

    public int getDown() {
        return this.down;
    }

    public int getForward() {
        return this.forward;
    }

    public int getBack() {
        return this.back;
    }

    public boolean getInAir() {
        return this.inAir;
    }

    // **************************************************
    // Set methods.
    // **************************************************
    public void setUp(int upAmount) {
        this.up = upAmount;
    }

    public void setDown(int downAmount) {
        this.down = downAmount;
    }

    public void setForward(int forwardAmount) {
        this.forward = forwardAmount;
    }

    public void setBack(int backAmount) {
        this.back = backAmount;
    }

    public void setInAir(boolean b) {
        this.inAir = b;
    }

}
