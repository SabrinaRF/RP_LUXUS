//import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Simulation
{ 
    private List<Actor> actors;
    protected int step;
    private City city;

    public Simulation(int width, int height)
    {
        this.actors = new LinkedList<Actor>();
        this.step = 10;
        this.city = new City(width,height);


        LuxCompany company = new LuxCompany(city);

        PassengerSource source = new PassengerSource(city, company);

        actors.addAll(0,company.getVehicles());
        actors.add(source);
        actors.add(new CityGUI(city));
    }
    

    public void run()
    {
        for(int i = 0; i < 500; i++){
            step++;
            step();
            wait(100);
        }
    }


    public void step()
    {
        for(Actor actor : actors) {
            actor.act();
        }
    }
    

    private void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e)
        {
            System.err.println("Sleep is disturbed. " + e);
        }
    }
}
