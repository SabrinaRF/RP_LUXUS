
import java.util.*;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

import static org.junit.Assert.*;



public class LuxCompanyTest {

  LuxCompany company = new LuxCompany(new City());
    /**
     * Teste 1 : compatibilidade entre resultado esperado e resultado obtido.
     * 
     * City foi instanciada com valores default dos parametros(30,30).
     */
    @Test 
    public void requestPickupTest(){
        
      
      Passenger passenger = new Passenger(new Location(10, 20), new Location(11, 12));

      boolean resultadoEsperado = true;
      boolean resultadoObtido = company.requestPickup(passenger);
      assertEquals(resultadoEsperado, resultadoObtido);
    }


    /**
     * Teste 2 : compatibilidade entre resultado esperado e resultado obtido.
     * 
     * City foi instanciada com valores default dos parametros(30,30).
     * 
     * Teste com resultado de captura de exceção IllegalArgumentException. 
     * Localização: classe Location. Ao passar algum valor negativo no construtor
     * da classe, é lançada uma exception.
     */
    @Test
    public void requestPickupTestException(){

      assertThrows(IllegalArgumentException.class, () -> company.requestPickup(new Passenger(new Location(-1, 0), new Location(11, -55))));
    }


    /* Teste 3: Tipagem do retorno
     *  getVehicles() deve retornar uma lista do tipo Vehicle.
     */
    @Test
    public void getVehiclesTest(){

      List<Vehicle> vehicleCarEsperado = new LinkedList<Vehicle>();

      assertEquals(vehicleCarEsperado.getClass(),company.getVehicles().getClass());

    }

    /*
     * Teste 4: Testando retorno não nulo
     *  Enquanto o houver um proximo valor, haverá repetição da condição e 
     * o retorno se dará como vehicle sempre que o método isFree() for verdadeiro.
     */
    @Test
    public void scheduleVehicleTest(){

      assertNotNull(company.scheduleVehicle());
    }

    /*
     * Teste 5: Teste de erro. Erro da classe MissingPassengerException esperado.
     */
    @Test
    public void arrivedAtPickupTest(){
      Location location = new Location(23,8);

      Vehicle vehicle = new LuxCar(company,location);

      assertThrows(MissingPassengerException.class, () -> company.arrivedAtPickup(vehicle));
    }
}
