import java.util.List;
import java.util.LinkedList;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Shuttle extends Vehicle implements DrawableItem {
    private Passenger passenger;
    private Shuttle bus;// criando o bus
    private Image emptyImage, passengerImage;// as imagens

    public Shuttle(LuxCompany company, Location location) {
        super(company, location);
        emptyImage = new ImageIcon(getClass().getResource("images/bus.png")).getImage();
        passengerImage = new ImageIcon(getClass().getResource("images/driverBus.png")).getImage();
    }

    public void act() {
        Location target = getTargetLocation();
        if (target != null) {
            Location next = getLocation().nextLocation(target);
            setLocation(next);
            if (next.equals(target)) {
                if (passenger != null) {
                    notifyPassengerArrival(passenger); // notificar a chegada do passageiro
                    offloadPassenger();
                } else {
                    notifyPickupArrival();
                }
            }
        } else {
            incrementIdleCount();
        }
    }

    public boolean isFree() {
        return getTargetLocation() == null && passenger == null;
    }

    public void setPickupLocation(Location location) {
        setTargetLocation(location);
    }

    public void pickup(Passenger passenger) {
        this.passenger = passenger;
        setTargetLocation(passenger.getDestination());
    }

    public void offloadPassenger() {
        passenger = null;
        clearTargetLocation();
    }

    public Image getImage() {
        if (passenger != null) {
            return passengerImage;
        } else {
            return emptyImage;
        }
    }

    public String toString() {
        return "luxCar at " + getLocation();
    }

}
