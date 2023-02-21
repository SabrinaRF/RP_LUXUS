import java.awt.Image;
import javax.swing.ImageIcon;


public class LuxCar extends Vehicle implements DrawableItem{
    private Passenger passenger;
    private LuxCar car;
    private Image emptyImage, passengerImage;
    

    public LuxCar(LuxCompany company, Location location){
        super(company,location);


        emptyImage = new ImageIcon(getClass().getResource("images/car.jpg")).getImage();

        passengerImage = new ImageIcon(getClass().getResource("images/driver.jpg")).getImage();
    
    }
    
 
    public void act()
    {
        Location target = getTargetLocation();
        if(target != null) {
            Location next = getLocation().nextLocation(target);
            setLocation(next);
            if(next.equals(target)) {
                if(passenger != null) {
                    notifyPassengerArrival(passenger); //notificar a chegada do passageiro
                    offloadPassenger();
                }
                else {
                    notifyPickupArrival();
                }
            }
        }
        else {
            incrementIdleCount();
        }
    }

    public boolean isFree()
    {
        return getTargetLocation() == null && passenger == null;
    }
    
  
    public void setPickupLocation(Location location)
    {
        setTargetLocation(location);
    }
    

    public void pickup(Passenger passenger)
    {
        this.passenger = passenger;
        setTargetLocation(passenger.getDestination());
    }

    public void offloadPassenger()
    {
        passenger = null;
        clearTargetLocation();
    }

    public Image getImage()
    {
        if(passenger != null) {
            return passengerImage;
        }
        else {
            return emptyImage;
        }
    }
    public String toString()
    {
        return "luxCar at " + getLocation ();
    }

    
}
