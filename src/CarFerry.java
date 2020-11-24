import java.util.ArrayList;
/** A class that creates a "Ferry" which has a {@code Transporter} object to give it the functionality of a transporter.*/
public class CarFerry {
    /** Declaration of a {@code Transporter} variable that when initiated contains functionality of a transporter. */
    private Transporter<Car> parentTransporter;
    /** Position variable in the x-axis*/
    private double xCoordinate = 0;
    /** Position variable in the y-axis*/
    private double yCoordinate = 0;

    /**Constructor that calls upon the contructor of {@code Transporter} when making a new {@code Transporter} object. */
    public CarFerry() {
        parentTransporter = new Transporter<>(xCoordinate,yCoordinate);
    }

    /** Method that returns the amount of objects "loaded" in the instance variable {@code parentTransporter}*/
    public int nrOfCarsLoaded() {
        return parentTransporter.nrOfEntities();
    }

    /** Method that sets the positions of a {@Code Car} object that is loaded in {@code parentTransporter}
     * @param loadedCar */
    private void giveLoadedCarSamePosition(Car loadedCar) {
        loadedCar.changePosition(this.xCoordinate, this.yCoordinate);
    }

    /** Method that checks the distance of the {@code CarFerry} object and a Car type argument in a 2D-Coordinate system
     * @param car*/
    private boolean checkDistanceFromCarOK(Car car) {
        return parentTransporter.checkDistanceFromEntityOK(xCoordinate, yCoordinate, car, 10);
    }

    /** Method that changes the position of the {@code Car} object entered as a argument away from the {@code CarFerry} in a 2D-Coordinate system.
     * @param unloadedCar */
    private void moveCarAwayFromFerryAfterUnload(Car unloadedCar) {
        unloadedCar.changePosition(this.xCoordinate - 2, this.yCoordinate + 2);
    }

    /** Method that return a list of {@code Car} that represents the loaded objects on the Transporter*/
    public ArrayList<Car> getCarsOnFerry() {
        return parentTransporter.getTransportedEntities();
    }

    /** Method that first checks the distance of to-be loaded object and checks if the transporter still have room for another object.
     * If within acceptable values then add object to the list in {@code parentTransporter}.
     * @param carToBeLoaded */
    public void loadCarOnFerry(Car carToBeLoaded) {
        if (checkDistanceFromCarOK(carToBeLoaded) && nrOfCarsLoaded() < 15 && !carToBeLoaded.getAssignment()) {
            parentTransporter.addToTransport(carToBeLoaded);
            giveLoadedCarSamePosition(carToBeLoaded);
        }
    }

    /** Method that unloads a number of objects defined by argument {@code nrOfCarsToUnload}, removes an amount of objects from list.
     * @param nrOfCarsToUnload */
    public void unloadCarsFromFerry(int nrOfCarsToUnload) {

        for (int i = 0; i < nrOfCarsToUnload; i++) {
            Car unloadedCar = parentTransporter.removeFromTransport(0);
            moveCarAwayFromFerryAfterUnload(unloadedCar);
        }

    }
}
