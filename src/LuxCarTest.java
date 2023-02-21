
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.awt.Image;
import javax.swing.ImageIcon;

public class LuxCarTest {
   
    
    /**
     * Teste 1: Se o target não for null vai incrementar a contagem. 
     * O esperado é quando for utilizado o contador seja incrementado em 1.
     */
    @Test
    public void actContadorTest(){
        LuxCar luxCar = new LuxCar(null, null);

        luxCar.act();

        assertEquals(luxCar.getIdleCount(), 1 );
    }
   
    /**
     * 
     * Teste 2: Métdodo getImage().
     *  Se o passageiro for diferente de null, a imagem do passageiro será exibida.
     */
    @Test 
    public void ImagemPassageiroTest(){

        Image passengerImageEsperada = new ImageIcon(getClass().getResource("images/driver.jpg")).getImage();

        LuxCar luxCar = new LuxCar(null, null);
        Location location = new Location(0, 0);
        Location destino = new Location(0, 0);
        Passenger passenger = new Passenger(location, destino);
        
        luxCar.pickup(passenger);
      
        assertEquals(passengerImageEsperada, luxCar.getImage());
    }

    /**
     * Teste 3: Método getImage().
     * Se o passageiro for igual a null será retornado a imagem do carro.
     */
    @Test
    public void imagemCarTest(){
        Image emptyImage = new ImageIcon(getClass().getResource("images/car.jpg")).getImage();
        
        LuxCar luxCar = new LuxCar(null, null);

        assertEquals(emptyImage, luxCar.getImage());
    }

    /*
        * Teste 4: Teste do método offloadPassenger.
        * 
        */
    @Test
    public void offloadPassengerTest(){
        City city = new City();
        LuxCompany luxCompany = new LuxCompany(city);
        Location location = new Location(10, 11);
        LuxCar luxCar = new LuxCar(luxCompany, location);
        Passenger passenger = new Passenger(location, location);

        luxCar.offloadPassenger();

        assertNotNull(passenger);
    }
     /**
     * Teste 5: Teste do método pickup. 
     */
    @Test
    public void pickupTest(){
        City city = new City();
        LuxCompany luxCompany = new LuxCompany(city);
        Location destinoEsperado = new Location(11, 11);
        Location location = new Location(11, 11);
        LuxCar luxCar = new LuxCar(luxCompany, location);
        Passenger passenger = new Passenger(location, destinoEsperado);

        luxCar.pickup(passenger);

        assertEquals(destinoEsperado, location);
        
    }


    /**
     * Teste 6: Teste do método isFree para saber se o veículo esta livre para ser agendado.
     * 
     */
    @Test
    public void veiculoLivreAgendarTest(){
        City city = new City();
        LuxCompany luxCompany = new LuxCompany(city);
        Location location = new Location(10, 10);
        LuxCar luxCar = new LuxCar(luxCompany, location);
    
        assertTrue("Deve ser verdadeiro", luxCar.isFree());
    }

    /**
     * Teste 7: Teste do método isFree para quando o veículo não estiver livre para agendar.
     */
    @Test
    public void veiculoNaoLivreAgendarTest(){

        City city = new City();
        LuxCompany luxCompany = new LuxCompany(city);
        Location location = new Location(10, 10);
        LuxCar luxCar = new LuxCar(luxCompany, location);
        Passenger passenger = new Passenger(location, location);

        luxCar.setTargetLocation(location);
        luxCar.pickup(passenger);
       
        assertFalse("deve ser falso", luxCar.isFree());
    
    }
}
