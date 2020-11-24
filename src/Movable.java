/***
 * An interface that is used by classes whose objects can move.
 */
public interface Movable {

    /*** Represents the direction north */
    int NORTH = 0;
    /*** Represents the direction east */
    int EAST = 1;
    /*** Represents the direction south */
    int SOUTH = 2;
    /*** Represents the direction west */
    int WEST = 3;

    /*** Used to keep track of the objects direction when a left turn is made */
    int[] LEFTTURN = new int[4];
    /*** Used to keep track of the objects direction when a right turn is made */
    int[] RIGHTTURN = new int[4];

    /***
     * Moves the object a distance 'currentSpeed' in the direction it is facing.
     */
    void move();

    /***
     * Changes the direction which the object is facing 90 degrees to the left.
     */
    void turnLeft();

    /***
     * Changes the direction which the object is facing 90 degrees to the right.
     */
    void turnRight();

}