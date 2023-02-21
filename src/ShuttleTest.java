import java.util.*;

import java.awt.Image;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShuttleTest {



    /**
     * Teste 1 : Valor nulo atribuído à target.
     * act()
     * Quando target tem valor null, idleCount deve ser incrementado em 1.
     * 
     * O que acontece: quando target é null, NullPointerException() é lançado
     * como resposta pelo método void setTargetLocation em Vehicle.
     * 
     * Conclusão: Conflito de resposta entre act() e setTargetLocation().
     * Não passou no teste.
     */
    @Test
    public void actTestTargetLocationNull(){
        Location location = new Location(18,44);
        LuxCompany luxCompany = new LuxCompany(new City(270,88));
        
        Shuttle shuttle = new Shuttle(luxCompany, location);
     
        shuttle.setTargetLocation(null);

        shuttle.act();
        int valorEsperado = 1;
        int valorObtido = shuttle.getIdleCount();
        assertEquals(valorEsperado,valorObtido);
    }

    /**
     * Teste 2 : Ao atribuir valores diferentes de nulos à target e passenger espera-se que
     * a chegada dos passageiros sejam notificadas(o método notifyPassengerArrivalBus() seja chamado) e 
     * o offloadPassenger.
     * act()
     * 
     * Conclusão: Retorno true.
     * Passou no teste.
     * 
     */
    @Test
    public void actTest2(){
        Location location = new Location(18,44);
        Location target = new Location(29,58);
        LuxCompany luxCompany = new LuxCompany(new City(270,88));
        
        Shuttle shuttle = new Shuttle(luxCompany, location);
     
        shuttle.setTargetLocation(target);
        Location newLocation = new Location(71,42);
        
        Passenger passenger = new Passenger(location,newLocation);
        List<Passenger> passengersList = new LinkedList<Passenger>();
        passengersList.add(passenger);
        shuttle.setPassengers(passengersList);
        boolean resultadoObtido = luxCompany.arrivedAtDestinationBus(shuttle,passengersList);
      
        assertTrue(resultadoObtido);
    }


    /**
     * Teste 3 : Espera-se que a lista passengers seja alterada com a adição de
     * um novo passager
     * Conclusão: Agora a lista tem um elemento do tipo passenger.
     * Passou no teste.
     * 
     */
    @Test
    public void setPassengersTest(){

        Location location = new Location(18,44);

        LuxCompany luxCompany = new LuxCompany(new City(270,88));
        
        Shuttle shuttle = new Shuttle(luxCompany, location);
        Location newLocation = new Location(11,38);
      
        
        Passenger passenger = new Passenger(location,newLocation);

        List<Passenger> passengers = new LinkedList<Passenger>();

        passengers.add(passenger);

        shuttle.setPassengers(passengers);
        
        assertEquals(passengers, shuttle.getPassengers());
    }


    /**
     * Teste 4 : Espera-se que location seja adicionada à lista de destinations
     * Conclusão: location está contida em destinations.
     * Passou no teste.
     * 
     */
    @Test
    public void setPickupLocationTest(){
        Location location = new Location(20,1);

        LuxCompany luxCompany = new LuxCompany(new City(270,88));
        
        Shuttle shuttle = new Shuttle(luxCompany, location);

        shuttle.setPickupLocation(location);
       
        boolean resultadoObtido = shuttle.getDestinations().contains(location);
        boolean resultadoEsperado = true;

        assertEquals(resultadoEsperado, resultadoObtido);

    }

    /**
     * Teste 5 : Verficação se um objeto foi adicionado á uma lista.
     * Conclusão: É apontado como false.
     * Passou no teste.
     * 
     */
    @Test
    public void setPickupLocationFalseTest(){
        Location location = new Location(20,1);

        LuxCompany luxCompany = new LuxCompany(new City(270,88));
        
        Shuttle shuttle = new Shuttle(luxCompany, location);

        shuttle.setPickupLocation(location);
        Location newLocation = new Location(11,31);
        boolean resultadoEsperado = shuttle.getDestinations().contains(newLocation);

        assertFalse("newLocation não foi adicionada á lista de destinations", resultadoEsperado);

    }

    /**
     * Teste 6 : O método deve retornar true sempre que for chamado.
     * Conclusão: Retorno true.
     * Passou no teste
     */
    @Test
    public void isFreeTest(){

        Location location = new Location(20,1);

        LuxCompany luxCompany = new LuxCompany(new City(270,88));
        
        Shuttle shuttle = new Shuttle(luxCompany, location);

        boolean resultadoObtido = shuttle.isFree();

        assertTrue(resultadoObtido);
    }

    /**
     * Teste 7 : Tipo do retorno.
     * Conclusão: Tipo esperado e obtido não são iguais. O tipo obtido foi ToolkitImage.
     * Não passou no teste.
     */
    
    @Test
    public void getImage(){
       
        Location location = new Location(50,32);

        LuxCompany luxCompany = new LuxCompany(new City(210,168));
        
        Shuttle shuttle = new Shuttle(luxCompany, location);

        shuttle.setPassengers(null);

        Image resultadoObtido = shuttle.getImage();

        assertEquals(Image.class, resultadoObtido.getClass());
  
    }


    /**
     * Teste 8 : Verficação se um objeto foi adicionado á uma lista.
     * Conclusão: É apontado como true.
     * Passou no teste.
     * 
     */
    @Test
    public void pickupTest(){
        Location location = new Location(20,1);
        Location newLocation = new Location(11,31);
        Passenger passenger = new Passenger(location,newLocation);

        LuxCompany luxCompany = new LuxCompany(new City(270,88));
        
        Shuttle shuttle = new Shuttle(luxCompany, location);

        shuttle.pickup(passenger);
        
        boolean resultadoEsperado = shuttle.getPassengers().contains(passenger);

        assertTrue("passenger foi adicionado à lista de passageiros", resultadoEsperado);

    }

}
