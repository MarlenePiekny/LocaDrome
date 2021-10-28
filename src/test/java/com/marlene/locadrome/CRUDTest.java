package com.marlene.locadrome;

import com.marlene.locadrome.dao.CarDao;
import com.marlene.locadrome.dao.CarImplDao;
import com.marlene.locadrome.model.Car;
import com.marlene.locadrome.model.CarList;

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
    private CarDao carDAO;


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
                .isEqualTo(carDAO.findById(1).getId());
    }

    @Test
    public void getAllCarsTest() {
        List<Car> body = testRestTemplate.getForObject("/cars", CarList.class).getCarList();
        assertThat(body).isNotNull();
        assertEquals(body.size(), carDAO.findAll().getCarList().size());
    }

    @Test
    public void addOneCarTest() {
        int DBSize = carDAO.findAll().getCarList().size();
        Car newCar = new Car("Renault", "Twingo", "jaune");
        testRestTemplate.postForObject("/cars", newCar, Car.class);
        CarImplDao carImplDao = new CarImplDao();
        assertEquals(carDAO.findById(carImplDao.findLastCarIdCreated()).getId(), carImplDao.findLastCarIdCreated());
        assertEquals(DBSize + 1, carDAO.findAll().getCarList().size());
    }

    @Test
    public void updateCarTest() {
        Car updatedCar = new Car("Citroën", "C4", "vert");
        testRestTemplate.put("/cars/3", updatedCar, Car.class);
        assertEquals(carDAO.findById(3).getBrand(), updatedCar.getBrand());
    }

    @Test
    public void deleteOneCarTest() {
        assertThat(carDAO.findById(2)).isNotNull();
        testRestTemplate.delete("/cars/2", Car.class);
        assertEquals(carDAO.findById(2), null);
    }


}
