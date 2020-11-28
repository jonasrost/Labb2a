import java.awt.*;

/***
 * Class that represents a Scania truck, which is a subclass to 'Truck'.
 */
public class Scania extends Truck{
    /***
     * The angle of the Scania trucks truck bed.
     */
    private int truckBedAngle;

    /***
     * Constructor of the class that calls upon the constructor in 'Truck'.
     */
    public Scania() {
        super(2, 400, Color.white, "Scania", 0, 320);
        this.truckBedAngle = 0;
    }

    /***
     * Method to decrease the angle of the truck bed to value, given that value is in the interval
     * [0, truckBedAngle].
     * @param value the new angle of the truck bed
     */
    public void decreaseAngleOfTruckBedTo(int value) {
        if ((truckBedAngle - value) >= 0 && (truckBedAngle - value) < this.truckBedAngle)
            truckBedAngle -= value;
    }

    /***
     * Method to increase the angle of the truck bed to value, given that value is in the interval
     * [truckBedAngle, 70].
     * @param value the new angle of the truck bed
     */
    public void increaseAngleOfTruckBed(int value) {
        if (getCurrentSpeed() == 0 && (truckBedAngle + value) > this.truckBedAngle && (truckBedAngle + value) <= 70)
            truckBedAngle += value;
    }

    /***
     * @return the current value of {@code truckBedAngle}
     */
    public int getCurrentAngleOfTruckBed() {
        return truckBedAngle;
    }

    /***
     * Sets currentSpeed to 0.1, given that truckBedAngle = 0.
     */
    @Override
    public void startEngine() {
        if (this.truckBedAngle == 0)
            currentSpeed = 0.01;
    }

    /***
     * Changes currentSpeed to the minimum of (currentSpeed + 6 * amount)
     * and enginePower, given that truckBedAngle = 0.
     * @param amount the value to increment the speed by.
     */
    @Override
    protected void incrementSpeed(double amount) {
        if (this.truckBedAngle == 0 )
            currentSpeed = Math.min(getCurrentSpeed() + 6 * amount, getEnginePower());
    }

    /***
     * Changes currentSpeed to the maximum of (currentSpeed - 10 * amount)
     * and enginePower.
     * @param amount the value to decrement the speed by.
     */
    @Override
    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - 10 * amount, 0);
    }
}
