package car_cartest;

public class Car {


    private String brand;
    private int maxSpeed;
    private int currentSpeed;

    public Car(String brand, int maxSpeed) {

        if (maxSpeed <= 0) {
            throw new IllegalArgumentException("Max speed must be positive");
        }

        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0;
    }


    void accelerate(int amount) {
        currentSpeed += amount;

        if (currentSpeed >= maxSpeed) {
            currentSpeed = maxSpeed;
        }
    }

    void brake(int amount) {
        currentSpeed -= amount;

        if (currentSpeed <= 0) {
            currentSpeed = 0;
        }
    }


    public String getBrand() {
        return brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }
}
