package car_cartest;

import javax.management.RuntimeErrorException;

public class CarTest {

    public static void main(String[] args) {


        Car car = new Car("Renault", 190);

        assertEquals(car.getCurrentSpeed(), 0);
        car.accelerate(60);
        assertEquals(car.getCurrentSpeed(), 60);
        car.accelerate(20);
        car.accelerate(30);
        car.accelerate(10);
        assertEquals(car.getCurrentSpeed(), 120);
        car.accelerate(40);
        car.brake(20);
        assertEquals(car.getCurrentSpeed(), 140);
        car.accelerate(100);
        assertEquals(car.getCurrentSpeed(), 190);
        car.brake(200);
        assertEquals(car.getCurrentSpeed(), 0);


    }


    static void assertEquals(Object actual, Object expected) {

        if (!actual.equals(expected)) {
            throw new RuntimeException("No es igual");
        }
    }
}

