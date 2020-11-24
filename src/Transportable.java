
/** An empty interface with the only function of being used as a separator between being transported and being able to transport
 * Classes that implement this is able to be transported*/
public interface Transportable {

    void assign();

    void unAssign();

    boolean getAssignment();

    double getXCoordinate();

    double getYCoordinate();


}
