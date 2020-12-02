import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.List;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    List<BufferedImage> objectImages;
    // BufferedImage objectImage;
    // To keep track of a singel cars position
    // Point objectPoint = new Point();
    List<Point> objectPoints;

    // TODO: Make this general for all cars
    void moveit(int x, int y, int indexOfCar){
        Point p = objectPoints.get(indexOfCar);
        p.x = x;
        p.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, java.util.List<Vehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        objectImages = new ArrayList<>();
        objectPoints = new ArrayList<>();

        for (Vehicle car: cars) {
            Point p = new Point((int) car.getXCoordinate(), (int) car.getYCoordinate());
            objectPoints.add(p);
        }

        // Print an error message in case file is not found with a try/catch block
       for (Vehicle car : cars) {
           try{
               objectImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+car.getModelName()+".jpg")));
           }catch (IOException ex)
           {
               ex.printStackTrace();
           }
       }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < objectImages.size(); i++) {
            BufferedImage component = objectImages.get(i);
            g.drawImage(component, objectPoints.get(i).x, objectPoints.get(i).y, null);
        }
    }
}
