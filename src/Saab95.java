import java.awt.*;

/***
 * Class that represents a Saab95, which is a subclass to 'Car'.
 */
public class Saab95 extends Car {

    /*** Keeps track of if the turbo is on or not */
    private boolean turboOn;

    /***
     * Constructor of the class that calls upon the constructor in 'Car'.
     */
    public Saab95(){
        super(2, 125, Color.red, "Saab95");
        turboOn = false;
    }

    /***
     * Sets turboOn to true.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /***
     * Sets turboOn to false.
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /***
     * Returns the speed factor of the Saab95
     * @return the speed factor of the Saab95
     */
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /***
     * Changes currentSpeed to the minimum of (currentSpeed + (the speed factor) * amount)
     * and enginePower.
     * @param amount the value that the speed factor is multiplied by.
     */
    @Override
    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    /***
     * Changes currentSpeed to the maximum of (currentSpeed - (the speed factor) * amount)
     * and 0.
     * @param amount the value that the speed factor is multiplied by.
     */
    @Override
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}
