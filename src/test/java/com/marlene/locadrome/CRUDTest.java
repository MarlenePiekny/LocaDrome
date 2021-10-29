package com.marlene.locadrome;

import com.marlene.locadrome.model.Car;
import com.marlene.locadrome.model.CarList;

import com.marlene.locadrome.service.CarImplService;
import com.marlene.locadrome.service.CarService;
import junit.framework.TestCase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CRUDTest extends TestCase {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private CarService carService;


    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();

    }

    @Test
    public void getOneCarTest() {
        Car body = testRestTemplate.getForObject("/cars/1", Car.class);
        assertThat(body.getId())
                .isNotNull()
                .isEqualTo(carService.findById(1).getId());
    }

    @Test
    public void getAllCarsTest() {
        List<Car> body = testRestTemplate.getForObject("/cars", CarList.class).getCarList();
        assertThat(body).isNotNull();
        assertEquals(body.size(), carService.findAll().getCarList().size());
    }

    @Test
    public void addOneCarTest() {
        int DBSize = carService.findAll().getCarList().size();
        Car newCar = new Car("Renault", "Twingo", "jaune");
        testRestTemplate.postForObject("/cars", newCar, Car.class);
        CarImplService carImplService = new CarImplService();
        assertEquals(carService.findById(carImplService.findLastCarIdCreated()).getId(), carImplService.findLastCarIdCreated());
        assertEquals(DBSize + 1, carService.findAll().getCarList().size());
    }

    @Test
    public void updateCarTest() {
        Car updatedCar = new Car("Citroën", "C4", "vert");
        testRestTemplate.put("/cars/3", updatedCar, Car.class);
        assertEquals(carService.findById(3).getBrand(), updatedCar.getBrand());
    }

    @Test
    public void deleteOneCarTest() {
        assertThat(carService.findById(2)).isNotNull();
        testRestTemplate.delete("/cars/2", Car.class);
        assertEquals(carService.findById(2), null);
    }


}
