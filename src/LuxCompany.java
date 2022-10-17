import java.util.*;

public class LuxCompany 
{
   private  String localName;
    private List<Vehicle> vehicles;
    private City city;
    private Map<Vehicle, Passenger> assignments;

    private LuxCompany company;
    private List<LuxCar> cars;

    public static final int TOTAL_LUXCARS = 5;


    public LuxCompany(City city)
    {
        this.setLocalName("TESTE");
        this.city = city;
        vehicles = new LinkedList<Vehicle>();
        cars = new LinkedList<LuxCar>();
        assignments = new HashMap<Vehicle, Passenger>();
        setupVehicles();
    }


    public boolean requestPickup(Passenger passenger)
    {
        Vehicle vehicle = scheduleVehicle();
        if(vehicle != null) {
            assignments.put(vehicle, passenger);
            vehicle.setPickupLocation(passenger.getPickupLocation());
            return true;
        }
        else {
            return false;
        }
    }
    

    public void arrivedAtPickup(Vehicle vehicle){
        
        Passenger passenger = assignments.remove(vehicle);
        if(passenger == null) {
            throw new MissingPassengerException(vehicle);
        }
        city.removeItem(passenger);
        vehicle.pickup(passenger);
    }
    

    public void arrivedAtDestination(Vehicle vehicle,Passenger passenger){

    }
    

    public List<Vehicle> getVehicles(LuxCompany company, Location location)
    {

        return vehicles;
    }
    

    private Vehicle scheduleVehicle()
    {
        Iterator<Vehicle> it = vehicles.iterator();
        while(it.hasNext()) {
            Vehicle vehicle = it.next();
            if(vehicle.isFree()) {
                return vehicle;
            }
        }
        return null;
    }

    public  void test(){
        System.out.println(this.getLocalName());
    }

    public void setupVehicles()
    {
        int cityWidth = city.getWidth();
        int cityHeight = city.getHeight();
        Random rand = new Random(12345);
        // Create the taxis.
        for(int i = 0; i < LuxCompany.TOTAL_LUXCARS; i++){
//
            LuxCar luxcar = new LuxCar(this,new Location(rand.nextInt(cityWidth),rand.nextInt(cityHeight)));
//            //não sei se é exatamente isso>>>> criado uma lista de carros cars
            this.cars.add(luxcar);
            this.city.addItem(luxcar);
//
        }
   }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }
}