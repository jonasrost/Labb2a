import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania());
        cc.cars.add(new Saab95());


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < cars.size(); i++) {
                Vehicle car = cars.get(i);

                if (checkIfVehicleInBoundaries(car)) {
                    car.turn180Degrees();
                }

                car.move();

                int x = (int) Math.round(car.getXCoordinate());
                int y = (int) Math.round(car.getYCoordinate());
                frame.drawPanel.moveit(x, y, i);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    private boolean checkIfVehicleInBoundaries(Vehicle car) {
        Point currentPos = new Point((int)car.getXCoordinate(),(int)car.getYCoordinate());

        return (currentPos.y > 500 || currentPos.y < 0 || currentPos.x < 0 || currentPos.x >700);
    }

    // Start the engine of all cars
    void startVehicles() {
        for (Vehicle car : cars)
            car.startEngine();
    }

    // Stop the engine of all cars
    void stopVehicles() {
        for (Vehicle car : cars)
            car.stopEngine();
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    private boolean checkIfVehicleCorrectClass(Vehicle car, Class<? extends Vehicle> T ) {
        return car.getClass() == T;
    }

    void turboOn() {
        for (Vehicle car : cars) {
            if (checkIfVehicleCorrectClass(car, Saab95.class))
                ((Saab95) car).setTurboOn();
        }
    }

    void turboOff() {
        for (Vehicle car : cars) {
            if (checkIfVehicleCorrectClass(car, Saab95.class))
                ((Saab95) car).setTurboOff();
        }
    }

    void liftBed(int liftAmount) {
        for (Vehicle car: cars) {
            if (checkIfVehicleCorrectClass(car, Scania.class))
                ((Scania) car).increaseAngleOfTruckBed(liftAmount);
        }
    }

    void lowerBed(int lowerAmount) {
        for (Vehicle car: cars) {
            if (checkIfVehicleCorrectClass(car, Scania.class))
                ((Scania) car).decreaseAngleOfTruckBedTo(lowerAmount);
        }
    }
}
