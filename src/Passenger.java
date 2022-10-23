import java.awt.Image;
import javax.swing.ImageIcon;


public class Passenger implements DrawableItem
{
    private Location pickup;
    private Location destination;
    private Image image;

    
    public Passenger(Location pickup, Location destination)
    {
        if(pickup == null) {
            throw new NullPointerException("Pickup location");
        }
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }
        this.pickup = pickup;
        this.destination = destination;
        
        image = new ImageIcon(getClass().getResource("images/user.jpg")).getImage();
    }
    

    public String toString()
    {
        return "Passenger travelling from " + pickup + " to " + destination;
    }

    
    public Image getImage()
    {
        return image;
    }
    
   
    public Location getLocation()
    {
        return pickup;
    }

    
    public Location getPickupLocation()
    {
        return pickup;
    }
    
    public Location getDestination()
    {
        return destination;
    }
}
