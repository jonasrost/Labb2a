import java.util.ArrayList;
/** Class that creates a workshop object that can load vehicles of a certain type. */
public class Workshop<VehicleType extends Vehicle> {
    /***
     * An ArrayList that contains all the objects currently in the workshop
     */
    private ArrayList<VehicleType> vehiclesInWorkshop;
    /***
     * An integer that represent the maximum value of cars which the workshop can contain.
     */
    private int maxVehicles;

    /**Constructor that creates a new ArrayList. */
    public Workshop(int maxVehicles) {
        vehiclesInWorkshop = new ArrayList<>();
        this.maxVehicles = maxVehicles;
    }
    /** Returns the amount of vehicles in the workshop*/
    public int nrOfVehiclesInWorkshop() {
        return vehiclesInWorkshop.size();
    }

    /** Method that checks if vehicle entered in parameter is already in the object.
     * @param <T>
     * @param vehicle */
    private <T extends VehicleType> boolean checkIfCarAlreadyInShop(T vehicle) {
        for (VehicleType t : vehiclesInWorkshop) {
            if (vehicle.equals(t))
                return true;
        }
        return false;
    }

    /** Method that adds the vehicle entered in parameter if it does not already exist in Workshop.
     * @param <T>
     * @param vehicle */
    public <T extends VehicleType> void putVehicleInWorkshop(T vehicle) {
        if (nrOfVehiclesInWorkshop() < maxVehicles && !checkIfCarAlreadyInShop(vehicle))
            this.vehiclesInWorkshop.add(vehicle);
    }

    /** Removes vehicle entered in parameter if it exists in object.
     * @param <T>
     * @param vehicle */
    public <T extends VehicleType> void removeVehicleFromWorkshop(T vehicle) {
        this.vehiclesInWorkshop.remove(vehicle);
    }

}