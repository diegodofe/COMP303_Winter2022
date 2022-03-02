
/**
 * Movement class allows users to create a movement, to then pass on to Drone
 * for execution.
 * Movement objects can also be created by Trick class.
 * 
 * @author Diego Dorantes-Ferreira 260854063
 */

public class Movement {

    // **************************************************
    // Fields
    // **************************************************
    private Direction direction;
    private Speed speed;
    private int distance;
    private boolean isRecording;
    private VideoFormat vFormat;

    // ****************************************************************
    // Overloaded Constructors. Attributes that are not specified
    // are set to default values.
    // ****************************************************************

    /**
     * Constructor #1
     *
     * @param direction is the direction of the movement.
     * 
     */
    public Movement(Direction direction) {
        assert direction != null;

        this.direction = direction;
        this.speed = Speed.LOW; // Default value.
        this.distance = 20; // Default value.
        this.isRecording = false; // Default value.
        this.vFormat = null; // Default value.
    }

    /**
     * Constructor #2
     *
     * @param direction is the direction of the movement.
     * @param vFormat   is the video recording format for the movement.
     */
    public Movement(Direction direction, VideoFormat vFormat) {
        assert direction != null && vFormat != null;

        this.direction = direction;
        this.speed = Speed.LOW; // Default value.
        this.distance = 20; // Default value.
        this.isRecording = true; // Set to true because vFormat was specified.
        this.vFormat = vFormat;
    }

    /**
     * Constructor #3
     *
     * @param direction is the direction of the movement.
     * @param Speed     is the speed of the movement.
     * 
     */
    public Movement(Direction direction, Speed speed) {
        assert direction != null && speed != null;

        this.direction = direction;
        this.speed = speed;
        this.distance = 20; // Default value.
        this.isRecording = false; // Default value.
        this.vFormat = null; // Default value.
    }

    /**
     * Constructor #4
     *
     * @param direction is the direction of the movement.
     * @param Speed     is the speed of the movement.
     * @param vFormat   is the video recording format for the movement.
     */
    public Movement(Direction direction, Speed speed, VideoFormat vFormat) {
        assert direction != null && speed != null && vFormat != null;

        this.direction = direction;
        this.speed = speed;
        this.distance = 20; // Default value.
        this.isRecording = true; // Set to true because vFormat was specified.
        this.vFormat = vFormat;
    }

    /**
     * Constructor #5
     *
     * @param direction is the direction of the movement.
     * @param distance  is the distance of the movement.
     */
    public Movement(Direction direction, int distance) {
        assert direction != null && distance > 0;

        this.direction = direction;
        this.speed = Speed.LOW; // Default value.
        this.distance = distance;
        this.isRecording = false; // Set to true because vFormat was specified.
        this.vFormat = null; // Default value.
    }

    /**
     * Constructor #6
     *
     * @param direction is the direction of the movement.
     * @param distance  is the distance of the movement.
     * @param vFormat   is the video recording format for the movement.
     */
    public Movement(Direction direction, int distance, VideoFormat vFormat) {
        assert direction != null && distance > 0 && vFormat != null;

        this.direction = direction;
        this.speed = Speed.LOW; // Default value.
        this.distance = distance;
        this.isRecording = true; // Set to true because vFormat was specified.
        this.vFormat = vFormat;
    }

    /**
     * Constructor #7
     *
     * @param direction is the direction of the movement.
     * @param Speed     is the speed of the movement.
     * @param distance  is the distance of the movement.
     * 
     */
    public Movement(Direction direction, Speed speed, int distance) {
        assert direction != null && speed != null && distance > 0;

        this.direction = direction;
        this.speed = speed;
        this.distance = distance;
        this.isRecording = false; // Default value.
        this.vFormat = null; // Default value.
    }

    /**
     * Constructor #8
     *
     * @param direction is the direction of the movement.
     * @param Speed     is the speed of the movement.
     * @param distance  is the distance of the movement.
     * @param vFormat   is the video recording format for the movement.
     */
    public Movement(Direction direction, Speed speed, int distance, VideoFormat vFormat) {
        assert direction != null && speed != null && distance > 0 && vFormat != null;

        this.direction = direction;
        this.speed = speed;
        this.distance = distance;
        this.isRecording = true; // Set to true because vFormat was specified.
        this.vFormat = vFormat;
    }

    // **************************************************
    // Get methods.
    // **************************************************

    public Direction getDirection() {
        return direction;
    }

    public Speed getSpeed() {
        return speed;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isRecording() {
        return isRecording;
    }

    public VideoFormat getvFormat() {
        return vFormat;
    }

    // **************************************************
    // Set methods.
    // **************************************************

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setRecording(boolean isRecording) {
        this.isRecording = isRecording;
    }

    public void setvFormat(VideoFormat vFormat) {
        this.vFormat = vFormat;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((direction == null) ? 0 : direction.hashCode());
        result = prime * result + distance;
        result = prime * result + ((speed == null) ? 0 : speed.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movement other = (Movement) obj;
        if (direction != other.direction)
            return false;
        if (distance != other.distance)
            return false;
        if (speed != other.speed)
            return false;
        return true;
    }
}
