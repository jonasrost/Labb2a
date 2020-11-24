import java.awt.*;

/***
 * Class that represents a Volvo240, which is a subclass to 'Car'.
 */
public class Volvo240 extends Car {

    /*** The trim factor of the car */
    private final static double trimFactor = 1.25;

    /***
     * Constructor of the class that calls upon the constructor in 'Car'.
     */
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }

    /***
     * Returns the speed factor of the Volvo240
     * @return the speed factor of the Volvo240
     */
    private double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    /***
     * Changes currentSpeed to the minimum value of enginePower and
     * (currentSpeed + (the speed factor)*amount).
     * @param amount the value to multiply the speed factor by.
     */
    @Override
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    /***
     * Changes currentSpeed to the maximum of 0 and
     * (currentSpeed - (the speed factor)*amount
     * @param amount the value to multiply the speed factor by
     */
    @Override
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
