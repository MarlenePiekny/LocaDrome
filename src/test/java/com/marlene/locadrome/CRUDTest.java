package com.marlene.locadrome;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.marlene.locadrome.dao.CarDao;
import com.marlene.locadrome.dao.CarImplDao;
import com.marlene.locadrome.model.Car;
import com.marlene.locadrome.model.CarList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Array;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CRUDTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private CarDao carDAO;

    @Test
    public void getOneCarTest() {
        Car body = testRestTemplate.getForObject("/cars/1", Car.class);
        assertThat(body.getId())
                .isNotNull()
                .isEqualTo(carDAO.findById(1).getId());
    }

    @Test
    public void getAllCarsTest() {
        CarList body = testRestTemplate.getForObject("/cars", CarList.class);
        assertThat(body).isNotNull();
        assertEquals(body.getCarList().size(), carDAO.findAll().getCarList().size());
    }
//
//    private List<Car> CarListIntoListOfCars(CarList carList) {
//        String[] carListString = String.valueOf(carList).split(",");
//
//    }


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
