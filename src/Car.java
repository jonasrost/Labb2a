import java.awt.*;

/** Car is an abstract class made to categorise objects that falls under the "car" section of the vehicle domain.*/
public abstract class Car extends Vehicle implements Transportable{

    private boolean assigned = false;

    /***
     * Constructor of the class
     * @param nrDoors the number of doors the truck has
     * @param enginePower represents the engine power of the truck
     * @param color the color of the truck
     * @param modelName the model of the truck
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, double xCord, double yCord) {
        super(nrDoors, enginePower, color, modelName, xCord, yCord);
    }

    public void assign() {
        this.assigned = true;
    }

    public void unAssign() {
        this.assigned = false;
    }

    public boolean getAssignment() {
        return assigned;
    }

}
