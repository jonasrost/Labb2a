import java.util.ArrayList;
/** A class that contains the functionality to transport object. Usually created as an instance variable in the objects
 * that want to be able to transport a certain {@code TransportedEntity} */
public class Transporter<TransportedEntity extends Transportable> {

    /** An arraylist that contains all the entities that are currently being "transported"*/
    private ArrayList<TransportedEntity> transportedEntities;

    /** Constructor that creates an arraylist to contain the transported objects and creates an position in a 2D-Coordinate system
     * based on the arguments
     * @param x
     * @param y */
    public Transporter(double x, double y) {
        transportedEntities = new ArrayList<>();
    }

    /** Returns the size of the arraylist in object*/
    public int nrOfEntities() {
        return transportedEntities.size();
    }
    /** returns the list that contains the objects being transported*/
    public ArrayList<TransportedEntity> getTransportedEntities() {
        return transportedEntities;
    }
    /** Method that adds an object to the arraylist with transported objects*/
    public <T extends TransportedEntity> void addToTransport(T entity) {
        transportedEntities.add(entity);
        entity.assign();
    }
    /** Method that removes an object in the arraylist with transported objects*/
    public TransportedEntity removeFromTransport(int indexToRemove) {
        TransportedEntity entity = transportedEntities.remove(indexToRemove);
        entity.unAssign();
        return entity;
    }

    /***
     * Method that checks the distance of the transporter object and a entity type argument in a 2D-Coordinate system
     * @param xCord x coordinate of transporter object
     * @param yCord y coordinate of transporter object
     * @param entity transported object
     * @param acceptableDist acceptable distance between objects
     * @param <T>
     * @return
     */
    public <T extends TransportedEntity> boolean checkDistanceFromEntityOK(double xCord, double yCord, T entity, double acceptableDist) {
        double deltaX = Math.abs(xCord - entity.getXCoordinate());
        double deltaY = Math.abs(yCord - entity.getYCoordinate());
        double delta = Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));

        return (delta < acceptableDist);
    }

}