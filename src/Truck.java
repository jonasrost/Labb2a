import java.awt.*;
/** Truck is an abstract class made to categorise objects that falls under the "truck" section of the vehicle domain.*/
public abstract class Truck extends Vehicle {


    /***
     * Constructor of the class
     * @param nrDoors the number of doors the truck has
     * @param enginePower represents the engine power of the truck
     * @param color the color of the truck
     * @param modelName the model of the truck
     */
    public Truck(int nrDoors, double enginePower, Color color, String modelName, double xCord, double yCord) {
        super(nrDoors, enginePower, color, modelName, xCord, yCord);
    }

}
