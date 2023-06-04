package vehicle;


import java.util.Objects;

public abstract class Vehicle {
    private static int idCount = 0;
    private final int id;
    private double kilometrage;
    private String modelName;
    private int maxPassengers;
    private int maxSpeed;

    //type /**parameter c'tor   */
    public Vehicle(String modelName, int maxPassengers, int maxSpeed) {
        this.kilometrage = 0;
        this.modelName = modelName;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
        id = idCount++;
    }


    //type/**get model name*/
    public String getModelName() {
        return modelName;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void move(double distance) {
        this.kilometrage += distance;
    }

    public void resetKilometrage() {
        this.kilometrage = 0;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id && Double.compare(vehicle.kilometrage, kilometrage) == 0 && maxPassengers == vehicle.maxPassengers && maxSpeed == vehicle.maxSpeed && Objects.equals(modelName, vehicle.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kilometrage, modelName, maxPassengers, maxSpeed);
    }
}
