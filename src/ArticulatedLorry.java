import java.awt.*;
import java.util.ArrayList;
/** A class that has the functionality of a transporter by having a {@code Transporter} object as a variable. */
public class ArticulatedLorry extends Truck {
    /** Declaration of a {@code Transporter} variable that when initiated contains functionality of a transporter. */
    private Transporter<Car> parentTransporter;
    /** Boolean variable if Lorry has ramp lifted or not.*/
    private boolean rampLifted;

    /** Constructor for Class that calls for Supertype's constructor and assigns a {@code Transporter} object and assigns {@code rampLifted} to true.*/
    public ArticulatedLorry() {
        super(2, 800, Color.blue, "ArticulatedLorry", 0, 0);
        parentTransporter = new Transporter<>(this.getXCoordinate(), this.getYCoordinate());
        rampLifted = true;
    }

    /** Method that changes the variable {@code rampLifted} if currentSpeed is 0*/
    public void setDownRamp() {
        if (getCurrentSpeed() == 0)
            this.rampLifted = false;
    }

    /** Method that changes the variable {@code rampLifted} to true.*/
    public void liftUpRamp() {
        this.rampLifted = true;
    }

    /** Method that sets the loaded objects' positions to the same as the transporter in a 2D-Coordinate system*/
    private void giveLoadedCarSamePosition(Car loadedCar) {
        loadedCar.setXCoordinate(this.getXCoordinate());
        loadedCar.setYCoordinate(this.getYCoordinate());
    }

    /** Method that returns the amount of objects loaded in the {@code Transporter} object's list.*/
    public int nrOfCarsLoaded() {
        return parentTransporter.nrOfEntities();
    }


    /** Method that checks the distance of the {@code ArticulatedLorry} object and a Car type argument in a 2D-Coordinate system
     * @param car*/
    private boolean checkDistanceFromCarOK(Car car) {
        return parentTransporter.checkDistanceFromEntityOK(this.getXCoordinate(), this.getYCoordinate(), car, 10);
    }

    /** Method that return a list of {@code Car} objects that represents the loaded objects on the Transporter*/
    public ArrayList<Car> getCarsOnLorry() {
        return parentTransporter.getTransportedEntities();
    }
    /** Method that first checks the distance of to-be loaded object and checks if the transporter still have room for another object.
     * If within acceptable values then add object to the list in {@code parentTransporter}.
     * @param carToBeLoaded */
    public void loadCarOnLorry(Car carToBeLoaded) {
        if (checkDistanceFromCarOK(carToBeLoaded) && !rampLifted && nrOfCarsLoaded() < 5 && !carToBeLoaded.getAssignment()) {
            carToBeLoaded.stopEngine();
            parentTransporter.addToTransport(carToBeLoaded);
            giveLoadedCarSamePosition(carToBeLoaded);
        }
    }

    /** Method that changes the position of the {@code Car} object entered as a argument away from the {@code ArticulatedLorry} in a 2D-Coordinate system.
     * @param unloadedCar */
    private void moveCarAwayFromTransportAfterUnload(Car unloadedCar) {
        unloadedCar.setXCoordinate(this.getXCoordinate() - 2);
        unloadedCar.setYCoordinate(this.getYCoordinate() + 2);
    }

    /** Method that unloads a number of objects defined by argument {@code nrOfCarsToUnload}, removes that amount of objects from list.
     * @param nrOfCarsToUnload */
    public void unloadCarsFromLorry(int nrOfCarsToUnload) {
        if (!rampLifted) {
            for (int i = 0; i < nrOfCarsToUnload; i++) {
                Car unloadedCar = parentTransporter.removeFromTransport(getCarsOnLorry().size()-1);
                moveCarAwayFromTransportAfterUnload(unloadedCar);
            }
        }
    }

    /** Changes current speed to the minimum between current speed * 2*{@code amount} and value of engine power
     * @param amount*/
    @Override
    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + 2 * amount, getEnginePower());
    }

    /** Changes current speed to the maximum between current speed - 30 * {@code amount} and 0
     * @param amount*/
    @Override
    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - 30 * amount, 0);
    }

    /** Method that moves the object according to its direction and also changes the position of every loaded object
     * in the {@code Transporter} object to the same coordinates in a 2D-Coordinate system.*/
    @Override
    public void move() {
        if (direction == NORTH)
            this.setYCoordinate(this.getYCoordinate() + getCurrentSpeed());
        else if (direction == EAST)
            this.setXCoordinate(this.getXCoordinate() + getCurrentSpeed());
        else if (direction == SOUTH)
            this.setYCoordinate(this.getYCoordinate() - getCurrentSpeed());
        else
            this.setXCoordinate(this.getXCoordinate() - getCurrentSpeed());


        for (Car loadedCar: parentTransporter.getTransportedEntities()) {
            loadedCar.changePosition(this.getXCoordinate(), this.getYCoordinate());
        }

    }
}
