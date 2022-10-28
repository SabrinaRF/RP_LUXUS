import java.util.List;
import java.util.LinkedList;
import java.awt.Image;
import javax.swing.ImageIcon;
    
public class Shuttle extends Vehicle implements DrawableItem
{
    private List<Location> destinations;
    private List<Passenger> passengers =new LinkedList<Passenger>();
    private Location location;
    private LuxCompany company;
   // private Shuttle bus;//criando o bus
    private Image emptyImage, passengerImage;//as imagens

    public Shuttle(LuxCompany company, Location location){
        super(company, location);
        //destinations = new LinkedList<Location>();
        //passengers = new LinkedList<Passenger>();
        emptyImage = new ImageIcon(getClass().getResource("images/bus.png")).getImage();
        passengerImage = new ImageIcon(getClass().getResource("images/driverBus.png")).getImage();
    }

    public void act()
    {
        Location target = getTargetLocation();
        if(target != null) {
            Location next = getLocation().nextLocation(target);
            setLocation(next);
            if(next.equals(target)) {
                for (int i = 0; i < passengers.size(); i++) {
                    if(passengers != null) {
                            notifyPassengerArrivalBus(passengers); //notificar a chegada do passageiro
                            offloadPassenger();
                    }else {
                        notifyPickupArrival();
                    }                   
                }                
            }
        }
        else {
            incrementIdleCount();
        }
    }

           
    
    public void companyLocation(Location location, LuxCompany company){
        this.company = company;
        this.location = location;
        }

    public void setPickupLocation(Location location){
       // destinations.add(location);
        //chooseTargetLocation();
        setTargetLocation(location);
    }
    

    public void pickup(Passenger passenger){
        passengers.add(passenger);
        destinations.add(passenger.getDestination());
        setTargetLocation(passenger.getDestination());
        
    }
    
    public void offloadPassenger(){
        passengers = null;
        clearTargetLocation();
    }   
    @Override
    public boolean isFree() {
        return getTargetLocation() == null && passengers == null;
        
    }
    
    @Override
    public Image getImage()
     { 
          //for (int i = 0; i < passengers.size(); i++) {
            if(passengers != null) {
                return passengerImage;
            }
            else {
                return emptyImage;
            }
        //}
        
    }

}
