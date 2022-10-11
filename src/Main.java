
public class Main{
    public static void main(String[] args) {
        Simulation simulation = new Simulation(new Location(10, 20),100, 100);
        simulation.run();
        simulation.step();
        //LuxCar luxCar = new LuxCar(new LuxCompany(new City(10,10)),new Location(10,20));
        //luxCar.act();
    }
}