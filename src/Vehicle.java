import java.awt.*;

/***
 * An abstract class that represents a car, which implements the interface 'Movable'.
 */
public abstract class Vehicle implements Movable {

    /*** Number of doors on the car */
    protected int nrDoors;
    /*** Engine power of the car */
    protected double enginePower;
    /*** The current speed of the car */
    protected double currentSpeed;
    /*** Color of the car */
    protected Color color;
    /*** The car model name */
    protected String modelName;

    /*** The start x coordinate of the car */
    private double xCord;
    /*** The start y coordinate of the car */
    private double yCord;

    /*** Initializes the start direction of the car */
    protected int direction = EAST;

    /***
     * Constructor of the class
     * @param nrDoors the number of doors the car has
     * @param enginePower represents the engine power of the car
     * @param color the color of the car
     * @param modelName the model of the car
     */
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, double xCord, double yCord){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.xCord = xCord;
        this.yCord = yCord;
        stopEngine();

        // Fills the arrays with values corresponding to a correct left respective right turn,
        // based on what direction the car is facing.
        LEFTTURN[NORTH] = WEST;
        LEFTTURN[EAST] = NORTH;
        LEFTTURN[SOUTH] = EAST;
        LEFTTURN[WEST] = SOUTH;

        RIGHTTURN[NORTH] = EAST;
        RIGHTTURN[EAST] = SOUTH;
        RIGHTTURN[SOUTH] = WEST;
        RIGHTTURN[WEST] = NORTH;
    }

    /***
     * Returns the number of doors of the car.
     * @return the number of doors of the car
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /***
     * Returns the engine power of the car.
     * @return the engine power of the car
     */
    public double getEnginePower(){
        return enginePower;
    }

    /***
     * Returns the current speed of the car.
     * @return the current speed of the car
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /***
     * Returns the color of the car.
     * @return the color of the car
     */
    public Color getColor(){
        return this.color;
    }

    /***
     * Returns the modelname of the car
     * @return the string containing the modelname of the car
     */
    public String getModelName() {
        return modelName;
    }

    /***
     * Allows the user to change the color of the car to clr.
     * @param clr the new color of the car
     */
    public void setColor(Color clr){
        color = clr;
    }

    /***
     * Sets currentSpeed to 0.1.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /***
     * Sets currentSpeed to 0.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /***
     * Abstract method to enable overriding in subclasses of this particular method
     * @param amount used as an multiplier
     */
    protected abstract void incrementSpeed(double amount);

    /***
     * Abstract method to enable overriding in subclasses of this particular method
     * @param amount used as an multiplier
     */
    protected abstract void decrementSpeed(double amount);

    /***
     * Method used to accelerate the car
     * @param amount value to accelerate the car by
     */
    public void gas(double amount){
        if (amount <= 1 && amount >=0)
            this.incrementSpeed(amount);
    }

    /***
     * Method used to deaccelerate the car
     * @param amount value to deaccelerate by
     */
    public void brake(double amount){
        if (amount <= 1 && amount >=0)
            this.decrementSpeed(amount);
    }

    /***
     * Moves the car a distance currentSpeed in the direction it is facing.
     */
    public void move() {
        if (direction == NORTH)
            yCord = yCord - currentSpeed;
        else if (direction == EAST)
            xCord = xCord + currentSpeed;
        else if (direction == SOUTH)
            yCord = yCord + currentSpeed;
        else
            xCord = xCord - currentSpeed;
    }

    /***
     * Changes the direction which the car is facing 90 degrees to the left.
     */
    public void turnLeft() {
        this.direction = LEFTTURN[direction];
    }

    /***
     * Changes the direction which the car is facing 90 degrees to the right.
     */
    public void turnRight() {
        this.direction = RIGHTTURN[direction];
    }

    /***
     * Turns the vehicle 180 degrees.
     */
    public void turn180Degrees() {
        this.turnLeft();
        this.turnLeft();
    }

    /***
     * Returns the current x-coordinate of the car
     * @return the value of xCord
     */
    public double getXCoordinate(){
        return this.xCord;
    }

    /***
     * Returns the current y-coordinate of the car
     * @return the value of yCord
     */
    public double getYCoordinate(){
        return this.yCord;
    }

    /***
     * Change the x coordinate of the cars position
     * @param newX the new x coordinate
     */
    protected void setXCoordinate(double newX) {
        this.xCord = newX;
    }

    /***
     * Change the y coordinate of the cars position
     * @param newY the new y coordinate
     */
    protected void setYCoordinate(double newY) {
        this.yCord = newY;
    }


    /***
     * Chenges both the x and y coordinate of the car
     * @param x new x coordinate
     * @param y new y coordinate
     */
    public void changePosition(double x, double y) {
        this.setXCoordinate(x);
        this.setYCoordinate(y);
    }

}
